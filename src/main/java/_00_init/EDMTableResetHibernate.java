package _00_init;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Blob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.web.store.model.FoodBean;
import com.web.store.model.Food_Genre;
import com.web.store.model.HomeBean;
import com.web.store.model.MovieBean;
import com.web.store.model.Movie_Genre;
import com.web.store.model.RoomBean;

import _00_init.util.HibernateUtils;
import _00_init.util.SystemUtils2018;

public class EDMTableResetHibernate {
	public static final String UTF8_BOM = "\uFEFF"; // 定義 UTF-8的BOM字元

	public static void main(String args[]) {

		String line = "";
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			File file = new File("data/food.txt");
			try (FileInputStream fis = new FileInputStream(file);
					InputStreamReader isr = new InputStreamReader(fis, "UTF8");
					BufferedReader br = new BufferedReader(isr);) {
				while ((line = br.readLine()) != null) {
					System.out.println("line=" + line);
					// 去除 UTF8_BOM: \uFEFF
					if (line.startsWith(UTF8_BOM)) {
						line = line.substring(1);
					}
					String[] token = line.split("\\|");
					FoodBean food = new FoodBean();
					food.setFoodName(token[0]);
					food.setFoodFileName(SystemUtils2018.extractFileName(token[1].trim()));
					// 讀取圖片檔
					Blob blob = SystemUtils2018.fileToBlob(token[2].trim());
					food.setFoodImg(blob);
					food.setFoodPrice(Integer.parseInt(token[3].trim()));
					food.setFoodType(token[4]);
					food.setFoodTypeId(Integer.parseInt(token[5].trim()));
					session.save(food);
					System.out.println("新增一筆Food紀錄成功");
				}
				// 印出資料新增成功的訊息
				session.flush();
				System.out.println("Food資料新增成功");
			}

		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}

		File file = new File("data/movie.txt");
		try (FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
				// 去除 UTF8_BOM: \uFEFF
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				MovieBean movie = new MovieBean();
				movie.setMovieName(token[0]);
				movie.setMovieFileName(SystemUtils2018.extractFileName(token[1].trim()));
				// 讀取圖片檔
				Blob blob = SystemUtils2018.fileToBlob(token[2].trim());
				movie.setMovieImg(blob);
				movie.setMovieEName(token[3]);
				movie.setMovieLength(token[4]);
				movie.setMovieRated(token[5]);
				movie.setMovieGenre1(token[6]);
				movie.setMovieTypeId(Integer.parseInt(token[7].trim()));
				movie.setMovieNote(token[8]);
				session.save(movie);
				System.out.println("新增一筆movie紀錄成功");
			}
			// 印出資料新增成功的訊息
			session.flush();
			System.out.println("movie資料新增成功");
		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}
		
		File file1 = new File("data/room.txt");
		try (FileInputStream fis = new FileInputStream(file1);
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
				// 去除 UTF8_BOM: \uFEFF
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				RoomBean room = new RoomBean();
				room.setRoomName(token[0]);
				room.setRoomFileName(SystemUtils2018.extractFileName(token[1].trim()));
				// 讀取圖片檔
				Blob blob = SystemUtils2018.fileToBlob(token[2].trim());
				room.setRoomImg(blob);
				room.setRoomSize(token[3]);
				room.setRoomPrice(token[4]);
				room.setRoomPopulation(token[5]);
				room.setRoomNameId(Integer.parseInt(token[6]));
				session.save(room);
				System.out.println("新增一筆room紀錄成功");
			}
			// 印出資料新增成功的訊息
			session.flush();
			System.out.println("movie資料新增成功");
		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}
		File file2 = new File("data/Home.txt");
		try (FileInputStream fis = new FileInputStream(file2);
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
				// 去除 UTF8_BOM: \uFEFF
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				HomeBean home = new HomeBean();
				home.setHomeName(token[0]);
				home.setHomeFileName(SystemUtils2018.extractFileName(token[1].trim()));
				// 讀取圖片檔
				Blob blob = SystemUtils2018.fileToBlob(token[2].trim());
				home.setHomeImg(blob);
				home.setHomeTpy(Integer.parseInt(token[3]));
				session.save(home);
				System.out.println("新增一筆home紀錄成功");
			}
			// 印出資料新增成功的訊息
			session.flush();
			System.out.println("home資料新增成功");
		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}
//-------------------------------以下genre-------------------------------------
		File file3 = new File("data/foodGenre.txt");
		try (FileInputStream fis = new FileInputStream(file3);
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
				// 去除 UTF8_BOM: \uFEFF
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				Food_Genre fGenre = new Food_Genre();
				fGenre.setfGenreName(token[0]);
				
				session.save(fGenre);
				System.out.println("新增一筆fGenre紀錄成功");
			}
			// 印出資料新增成功的訊息
			session.flush();
			System.out.println("food_genre資料表新增成功");
		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}
		
		File file4 = new File("data/movieGenre.txt");
		try (FileInputStream fis = new FileInputStream(file4);
				InputStreamReader isr = new InputStreamReader(fis, "UTF8");
				BufferedReader br = new BufferedReader(isr);) {
			while ((line = br.readLine()) != null) {
				System.out.println("line=" + line);
				// 去除 UTF8_BOM: \uFEFF
				if (line.startsWith(UTF8_BOM)) {
					line = line.substring(1);
				}
				String[] token = line.split("\\|");
				Movie_Genre mGenre = new Movie_Genre();
				mGenre.setmGenreName(token[0]);
				mGenre.setmGenreEName(token[1]);
				session.save(mGenre);
				System.out.println("新增一筆mGenre紀錄成功");
			}
			// 印出資料新增成功的訊息
			session.flush();
			System.out.println("movie_genre資料表新增成功");
		} catch (Exception e) {
			System.err.println("新建表格時發生例外: " + e.getMessage());
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
		factory.close();
	}

}