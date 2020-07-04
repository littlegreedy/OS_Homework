package pers.ap.sample.homework;

import javax.xml.soap.Text;

class Storage {
	private String[] products = new String[3];
	private int top = 0;

	public synchronized void push(String product,int index) {

		products[index] = product;
		TextT.texts[index].setText(product);
		top++;
		System.out.println(product);

		if (top == products.length ) {
			StringBuilder s= new StringBuilder();
			for(int i=0;i<products.length;++i){
				System.out.print(products[i]+" ");
				s.append(products[i]).append(" ");
			}
				TextT.texts[top].setText(s.toString());
		}
	}

}