package com.web.store.model;

public class RoomBeanWithImageData{
	
	RoomBean bean;
		String imageData;
		
		public RoomBeanWithImageData() {
		}
		public RoomBeanWithImageData(RoomBean bean, String iamgeData) {
			this.bean = bean;
			this.imageData = iamgeData;
		}
		public RoomBean getBean() {
			return bean;
		}
		public void setBean(RoomBean bean) {
			this.bean = bean;
		}
		public String getImageData() {
			return imageData;
		}
		public void setImageData(String imageData) {
			this.imageData = imageData;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("RoomBeanWithImageData [bean=");
			builder.append(bean);
			builder.append(", imageData=");
			builder.append(imageData);
			builder.append("]");
			return builder.toString();
		}
		
		
		
}