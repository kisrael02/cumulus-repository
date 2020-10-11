public class calendarTask extends genTask
{
  int month;
  int day;
  int year;

  public calendarTask(String name, int u, int t, boolean p, int m, int d, int y)
  {
    super(name, u, t, p);
    month = m;
    day = d;
    year = y;
  }

  void setMonth(int m)
  {
    month = m;
  }
  int getMonth()
  {
    return month;
  }

  void setDay(int d)
  {
    day = d;
  }
  int getDay()
  {
    return day;
  }

  void setYear(int y)
  {
    year = y;
  }
  int getYear()
  {
    return year;
  }
}