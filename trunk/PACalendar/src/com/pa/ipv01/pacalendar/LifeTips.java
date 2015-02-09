package com.pa.ipv01.pacalendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.pa.pacalendar.R;

public class LifeTips extends Activity {
	private TextView textView;
	String content = "Hãy làm theo một số cách dưỡi đây để các vật dụng bằng thủy tinh của nhà bạn đều sáng bóng, bền đẹp trong tết này nhé Cách giữ gìn đồ bằng thuỷ tinh ít vỡ do nước sôi Khi mới mua đồ bằng thuỷ tinh về, bạn hãy bỏ các món ấy vào nồi nước có pha muối rồi nấu cho nước sôi lên. Sau đó, bạn để nước nguội mới vớt ra rửa lại bằng nước lã. Chắc chắn đồ thuỷ tinh của bạn sẽ chịu nước sôi bền hơn. Tuy nhiên khi đi mua các món đồ thuỷ tinh, bạn đừng mua loại tệ quá, có nhiều bọt, mau vỡ hơn. - See more at: http://www.yakyo.vn/tin-tuc/noi-tro-dinh-duong/meo-chui-rua-ly-binh-bang-thuy-tinh-sang-bong.html#sthash.D9Z3DxuL.dpufĐể chúng sáng bóng lại như mới, bạn hãy rửa bằng nước nóng và nước rửa bát rồi tráng bằng nước có pha giấm. Bạn cũng có thể ngâm đám cốc ố đó vào nước pha dấm (hoặc có vắt chanh) rồi dùng vải mềm kỳ cọ Với chai lọ thủy tinh, bạn khó cho cả bàn tay qua miệng chai để lau rửa bên trong. Vậy hãy cho vào đó một ít gạo, nước sôi và lắc thật mạnh, những vết bẩn lưu cữu sẽ “bay đi”.Với những cửa kính bằng thủy tinh, mặt gương có vết bẩn do dấu tay dính mồ hôi chạm vào, bạn hãy xoa lên đó bằng các lát khoai tây tươi. Mặt gương, kính sẽ sáng và bóng lại.Với những đồ dùng pha lê, cần lau rửa cầu kỳ hơn, nhất là nếu nó có nhiều khe kẽ. Bạn hãy bôi kem đánh răng và kỳ cọ bằng bàn chải đánh răng mềm, sau đó rửa lại bằng nước pha dấm.Những chiếc gạt tàn thuốc lá bằng thủy tinh dùng lâu ngày sẽ đọng lại một lớp cáu bẩn cực kỳ cứng đầu. Bạn hãy ngâm nó một chút, rồi dùng vải tẩm nước muối thật đặc để lau.Với những cửa kính bằng thủy tinh, mặt gương có vết bẩn do dấu tay dính mồ hôi chạm vào, bạn hãy xoa lên đó bằng các lát khoai tây tươi. Mặt gương, kính sẽ sáng và bóng lại.Với những đồ dùng pha lê, cần lau rửa cầu kỳ hơn, nhất là nếu nó có nhiều khe kẽ. Bạn hãy bôi kem đánh răng và kỳ cọ bằng bàn chải đánh răng mềm, sau đó rửa lại bằng nước pha dấm.Với những cửa kính bằng thủy tinh, mặt gương có vết bẩn do dấu tay dính mồ hôi chạm vào, bạn hãy xoa lên đó bằng các lát khoai tây tươi. Mặt gương, kính sẽ sáng và bóng lại.Với những đồ dùng pha lê, cần lau rửa cầu kỳ hơn, nhất là nếu nó có nhiều khe kẽ. Bạn hãy bôi kem đánh răng và kỳ cọ bằng bàn chải đánh răng mềm, sau đó rửa lại bằng nước pha dấm.Những chiếc gạt tàn thuốc lá bằng thủy tinh dùng lâu ngày sẽ đọng lại một lớp cáu bẩn cực kỳ cứng đầu. Bạn hãy ngâm nó một chút, rồi dùng vải tẩm nước muối thật đặc để lau.Những chiếc gạt tàn thuốc lá bằng thủy tinh dùng lâu ngày sẽ đọng lại một lớp cáu bẩn cực kỳ cứng đầu. Bạn hãy ngâm nó một chút, rồi dùng vải tẩm nước muối thật đặc để lau.";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.lifetips);

		textView = (TextView) findViewById(R.id.lifetips_tvcontent);
		textView.setText(content);

	}

}
