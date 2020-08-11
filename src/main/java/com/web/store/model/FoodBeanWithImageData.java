package com.web.store.model;

public class FoodBeanWithImageData{
	
		FoodBean bean;
		String imageData;
		
		public FoodBeanWithImageData() {
		}
		public FoodBeanWithImageData(FoodBean bean, String iamgeData) {
			this.bean = bean;
			this.imageData = iamgeData;
		}
		public FoodBean getBean() {
			return bean;
		}
		public void setBean(FoodBean bean) {
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
			builder.append("FoodBeanWithImageData [bean=");
			builder.append(bean);
			builder.append(", imageData=");
			builder.append(imageData);
			builder.append("]");
			return builder.toString();
		}
		
		
		
}