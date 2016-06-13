package background;
import com.melloware.jintellitype.*;
public class HotKeyListener  implements HotkeyListener,IntellitypeListener
{
	@Override
	public void onHotKey(int e)
	{
		System.out.println(e);
	}

	@Override
	public void onIntellitype(int e)
	{
		System.out.println(e);
	}

}
