public class Book
{
		public String author;
		public String title;
		public String status; 
		public String isbn; 
		public String genre; 
		public String pid; 
		public Book() {}
		
		public Book(String a, String t, String s, String i, String g, String p)
		{
			this.author = a;
			this.title = t;
			this.status = s;
			this.isbn = i;
			this.genre = g;
			this.pid = p;
		}
		
}