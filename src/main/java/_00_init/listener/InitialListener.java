package _00_init.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import _00_init.util.GlobalService;
// 定義由IoC容器控管的Listener
// @WebListener
// 已由WebAppInitializer#onStartup()啟動本Listener
public class InitialListener implements ServletContextListener {   
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext context  = event.getServletContext();
//        context.setAttribute("Kitty", "我是凱蒂");
        context.setAttribute("SYSTEM",new GlobalService());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce)
    {
    }
}