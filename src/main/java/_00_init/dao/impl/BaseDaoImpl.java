package _00_init.dao.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.Clob;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _00_init.dao.BaseDao;
import _00_init.util.GlobalService;
import _01_register.model.MemberBean;


@Repository
public class BaseDaoImpl implements BaseDao {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元
	@Autowired
	SessionFactory factory;

	@Autowired
	ServletContext ctx;
	
	@Override
	public void initData() {
		
		String realPath = ctx.getRealPath("/");
		
		Transaction tx = null;
		String line = "";
		int count = 0;

		Session session = factory.openSession();

		try {
			tx = session.beginTransaction();

			// 3. Member表格
			// 3-1由"data/Input.txt"逐筆讀入Member表格內的初始資料，
			// 然後依序新增到Member表格中
			try (FileInputStream fis = new FileInputStream(realPath + "/data/Input.txt");
					InputStreamReader isr0 = new InputStreamReader(fis, "UTF-8");
					BufferedReader br = new BufferedReader(isr0);) {
				while ((line = br.readLine()) != null) {
					String[] sa = line.split("\\|");
					MemberBean bean = new MemberBean();
					bean.setMemberId(sa[0]);
					bean.setName(sa[1]);
					String pswd = GlobalService.getMD5Endocing(GlobalService.encryptString(sa[2]));
					bean.setPassword(pswd);
					bean.setAddress(sa[3]);
					bean.setEmail(sa[4]);
					bean.setTel(sa[5]);
					bean.setUserType(sa[6]);
					bean.setTotalAmt(Double.parseDouble(sa[7]));
					bean.setTs(new java.sql.Timestamp(System.currentTimeMillis()));
					// --------------處理Blob(圖片)欄位----------------
					Blob sb = GlobalService.fileToBlob(realPath + "/" + sa[8]);
					bean.setMemberImage(sb);
					String imageFileName = sa[8].substring(sa[8].lastIndexOf("/") + 1);
					bean.setFileName(imageFileName);
					Clob clob = GlobalService.fileToClob(realPath + "/" + sa[9]);
					bean.setComment(clob);
					bean.setUnpaid_amount(0.0);
					session.save(bean);
					count++;
					System.out.println("新增" + count + "筆記錄:" + sa[1]);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}

	}
}
