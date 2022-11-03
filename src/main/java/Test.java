import com.bilgeadam.dao.BookDao;
import com.bilgeadam.dao.BookDetailDao;
import com.bilgeadam.dao.StudentDao;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.Student;

public class Test {

	public static void main(String[] args) {

		BookDetail bookDetail = new BookDetail();
		BookDetailDao bookDetailDao= new BookDetailDao();
		
		bookDetailDao.create(bookDetail);

		Book b1 = new Book();
		b1.setName("abc");
		bookDetail.setBook(b1);
		b1.setBookDetail(bookDetail);

		BookDao bookdao = new BookDao();
		bookdao.create(b1);
		Book b2= new Book();
		b2.setName("aaa");
		b2.setBookDetail(bookDetail);
		bookdao.create(b2);
		
		
		Student s1= new Student();
		s1.setUsername("sdfs");
		s1.setPassword("123");
		
		StudentDao studentDao= new StudentDao();
		studentDao.create(s1);
		
		s1.setUsername("afagag");
		studentDao.update(s1.getStudentId(), s1);
		
		
		b1.setName("cba");
		bookdao.update(b1.getBookid(), b1);
		
		
//		LibraryService lb= new LibraryService();
//		lb.borrowBook(b1, s1);

	}

}
