
public class QNodes<String>
{
	private String val;
	public QNodes<String> y;
	public QNodes<String> n;
	public QNodes<String> prev;
	
	public QNodes(String val)
	{
		this(val, null,null,null);
	}
	
	public QNodes(String val, QNodes<String> y,QNodes<String> n, QNodes<String> prev)
	{
		this.val = val;
		this.y = y;
		this.n = n;
		this.prev = prev;
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
