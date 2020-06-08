package pers.ap.sample.homework2;

class Storage {
	private String[] products = new String[3];
	private int top = 0;

	public synchronized void push(String product) {
		products[top] = product;
		System.out.println(product);
//		TextT.texts[top].setText(product);
		top++;

		if (top == products.length ) {
			String s="";
			for(int i=0;i<products.length;++i){
				System.out.print(products[i]+" ");
				s+=products[i]+" ";
			}
//				TextT.texts[top].setText(s);
		}
	}

}