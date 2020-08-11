package com.web.store.model;

public class HomeBeanWithImageData{
	
		HomeBean bean;
		String imageData;
		
		public HomeBeanWithImageData() {
		}
		public HomeBeanWithImageData(HomeBean bean, String iamgeData) {
			this.bean = bean;
			this.imageData = iamgeData;
		}
		public HomeBean getBean() {
			return bean;
		}
		public void setBean(HomeBean bean) {
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
			builder.append("HomeBeanWithImageData [bean=");
			builder.append(bean);
			builder.append(", imageData=");
			builder.append(imageData);
			builder.append("]");
			return builder.toString();
		}
		
		
		
}