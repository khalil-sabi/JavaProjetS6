package fc.Application.MVC.ViewModels;

public class MovieViewModel
{
	public int m_Id;
	public String m_Title;
	public int m_Year;
	
	public MovieViewModel(int id, String title, int year)
	{
		m_Id = id;
		m_Title = title;
		m_Year = year;
	}
}
