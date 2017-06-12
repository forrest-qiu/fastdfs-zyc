package com.softsz.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StructGroupStat;
import org.csource.fastdfs.StructStorageStat;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class MyTest {
	
	@Test
	public void fun(){
		
		try {
			ClientGlobal.init("D:\\developerdoc\\FastDFS\\fastdfs-zyc-master\\fastdfs-zyc-master\\src\\main\\resources\\fdfs_client.conf");
			System.out.println("配置文件初始化成功！！");
			System.out.println("network_timeout=" + ClientGlobal.g_network_timeout + "ms");
	  		System.out.println("charset=" + ClientGlobal.g_charset);
			 TrackerClient tracker = new TrackerClient();
	         TrackerServer trackerServer = tracker.getConnection();
	         if (trackerServer == null) {
	            System.out.println("服务连接失败！");
	         }
			
	         StructGroupStat[] groupStats = tracker.listGroups(trackerServer);
	         
	         if(groupStats!=null){
	        	 for (StructGroupStat sg : groupStats) {
	 				System.out.println("激活的storage连接个数"+sg.getActiveCount());
	 				
	 				System.out.println("连接组名称："+sg.getGroupName());
	 				
	 				System.out.println("连接的storage个数"+sg.getStorageCount());
	 				
	 				 StructStorageStat[] storageStats = tracker.listStorages(trackerServer, sg.getGroupName());
	 				 
	 				 if(storageStats!=null){
	 					for (StructStorageStat ss : storageStats) {
							System.out.println(ss.getDomainName()+"storage的ip地址："+ss.getIpAddr());
						}
	 				 }
	 			}
	         }
	        
	         
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}
