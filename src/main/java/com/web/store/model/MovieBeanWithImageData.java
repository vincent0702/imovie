package com.web.store.model;

public class MovieBeanWithImageData{
	
		MovieBean bean;
		String imageData;
		
		public MovieBeanWithImageData() {
		}
		public MovieBeanWithImageData(MovieBean bean, String iamgeData) {
			this.bean = bean;
			this.imageData = iamgeData;
		}
		public MovieBean getBean() {
			return bean;
		}
		public void setBean(MovieBean bean) {
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
			builder.append("MovieBeanWithImageData [bean=");
			builder.append(bean);
			builder.append(", imageData=");
			builder.append(imageData);
			builder.append("]");
			return builder.toString();
		}
		
		
		
}