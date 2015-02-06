package com.pa.ipv01.object;

import java.util.Random;

public class objDanhNgon {

	String[] danhNgon=new String[]{"Tôi đi tuy châm, nhưng không bao giờ lùi!"
									, "Nếu thực sự muốn yêu thương, ta phải học cách tha thứ-Teresa"
									, "Khi nhìn về phía mặt trời các bóng tối sẽ khuất sau lưng ta. (Whitman)"
									, "Chưa hề có ai, kể cả thi sĩ, có thể đo lường sức chứa của trái tim.(Z.Fitgerald)"
									, "Sẽ không có gì khó nếu ta biết nhìn nó bằng ánh sáng của con tim. (E.Glassglow)"
									, "Có những món quà được trao đi để được tiếp tục trao cho người khác. (J.Bennett)"
									, "Cái nhìn của chúng ta quyết định cuộc sống của chúng ta. (F.W.Lemore)"
									, "Mực có thể tẩy được nhưng ký ức thì không xóa nhòa theo thời gian. (Anita Loos)"
									, "Ở đâu có tình yêu, ở đó có sự sống. (Lev Tolstoy)"
									, "Mọi thứ chỉ thật sự chấm dứt khi bạn thôi không cố gắng. (Khuyết Danh)"
									, "Thất bại thật sự chỉ khi bạn thật sự bỏ cuộc."
									, "Có những lời chia tay không phải vì hết yêu, mà đơn giản không bên nhau được nữa."
									, "Yêu một người không phải người đó đặc biệt, mà là vì cảm giác đặc biệt."
									, "Sống chậm lại, nghĩ khác đi, và yêu thương nhiều hơn."
									, "Có thể với thế giới, bạn chỉ là một người.Nhưng với một người nào đó, bạn là cả thế giới."
									, "Đừng lãng phí thời gian với những người không dành thời gian cho bạn."
									, "Chỉ cần mỉm cười mỗi ngày, bạn sẽ phát hiện cuộc sống thật thú vị."
									, "Nghịch cảnh sẽ làm bạn hiểu bản thân bạn hơn."
									, "Đừng để bị thúc đẩy bởi khó khăn, mà hãy để những ước mơ thúc giục bạn."
									, "Tình yêu như cánh bướm, bạn càng muốn bắt nó càng bay xa hơn."
									, "Đừng nên nói 'Yêu' khi bạn chưa chắc chắn."
									, "Tình yêu không làm bạn hoàn hảo, nó sẽ làm bạn tốt hơn."
									, "Quà tặng quý giá nhất là sự khoan dung."
									, "Kẻ thù lớn nhất của đời người là chính bạn. (Phật dạy)"
									, "Tiền thì chỉ có giá trị khi nó mang lại hạnh phúc cho người khác."
									, "Nếu bạn làm việc bạn luôn làm, bạn sẽ nhận được thứ bạn luôn nhận.(Anon)"
									, "Nếu bạn  nghỉ ngơi quá lâu, bạn sẽ bị rỉ sét. (Helen Hayes)"
									, "Những cánh cửa cơ hội được đánh dấu đẩy và kéo. (Vô Danh)"
									, "Tất cả vinh quang đều bắt đầu từ sự dám bắt đầu. (Eugene F Ware)"
									, "Ngôn ngữ của tình bạn không phải ngôn từ mà là ý nghĩa.(Henry)"
									, "Tình bạn của một người là thước đo tốt nhất giá trị của họ.(C.Darwin)"
									, "Cuộc sống vốn không công bằng, Hãy tập quen dần với điều đó. (Bill Gates)"
									, "Hãy hòa nhã với kẻ dở hơi, bạn só thể phải làm việc với họ. (Bill Gates)"
									, "Người duy nhất tôi biết đã làm mất 1/4 tỉ USD/năm là chính tôi. (Steven Jobs)"
									, "Tôi có một câu thần chú - sự tập trung và tính đơn giản. (Steven Jobs)"
									, "Tôi luôn phấn đấu hết sức, tôi biết mình đã làm được một việc tuyệt vời. (Steven Jobs)"
									, "Bạn không thể thấy trước tương lai, nhưng phải luôn luôn hướng đến nó. (Steven Jobs)"
									, "Sáng tạo có nghĩa là nói 'Không' với hàng nghìn thứ. (Steven Jobs)"
									, "Chất lượng quan trọng hơn số lượng. Một lần home-run còn hơn hai lần double. (Steven Jobs)"
									, "Tôi muốn phát ra một âm thanh trong vũ trụ. (Steven Jobs)"
									, "Stay Hungry, stay foolish. (Steven Jobs)"
									, "Nếu bạn chưa tìm thấy nó, Hày hướng trái tim mình về mọi việc. (Steven Jobs)"
									, "Thời gian của bạn có hạn, do đó đừng lãng phí nó cho C.S người khác. (Steven Jobs)"
									, "Làm một tên cướp biển thú vị hơn là làm một anh lính hải quân. (Steven Jobs)"
									, "Cách duy nhất để cảm thấy hài lòng là làm những việc mà bạn cho là vĩ đại. (Steven Jobs)"
									, "Đừng để ý kiến của người khác làm mất tiếng nói của trái tim bạn. (Steven Jobs)"
									, "Keep looking. Don't settle. (Steven Jobs)"
									, "Sometimes life is going to hit you in the head with a brick. Don't lose faith. (Steven Jobs)"
									, "Sống khát khao. Sống dại khờ. (Steven Jobs)"};
	
	public String randDanhNgon()
	{
		Random rd=new Random();
		int i=rd.nextInt(49);
		
		return danhNgon[i];
	}
}
