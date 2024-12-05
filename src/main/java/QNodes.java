
public class QNodes<String>
{
	private String val;
	private QNodes<String> y;
	private QNodes<String> n;
	
	public QNodes(String val)
	{
		this(val, null,null);
	}
	
	public QNodes(String val, QNodes<String> y,QNodes<String> n)
	{
		this.val = val;
		this.y = y;
		this.n = n;
	}
	
	public String getVal()
	{
		return val;
	}
	
	public QNodes<String> getYes()
	{
		return y;
	}
	public QNodes<String> getNo()
	{
		return n;
	}

}
