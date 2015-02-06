package com.pa.ipv01.object;

public class objNgayLe {

	public boolean red=false;
	String[] ngayLeDuong=new String[]{"1/1-Tết Dương Lịch-Đ"
									, "3/2-Ngày Thành Lập Đảng CSVN"
									, "14/2-Lễ Tình Nhân"
									, "27/2-Ngày Thầy thuốc Việt Nam"
									, "8/3-Quốc Tế Phụ Nữ"
									, "26/3-Ngày Thành Lập Đoàn TNCSHCM"
									, "21/4-Ngày Sách Việt Nam"
									, "30/4-Ngày Giải Phóng Miền Nam-Đ"
									, "1/5-Ngày Quốc Tế Lao Động"
									, "7/5-Chiến Thắng Điện Biên Phủ"
									, "8/5-Ngày Chữ Thập Đỏ và Trăng Lưỡi Liềm Đỏ QT"
									, "19/5-Ngày sinh Chủ Tịch Hồ Chí Minh"
									, "1/6-Ngày Quốc Tế Thiếu Nhi và Lế Phật Đảng"
									, "20/6-Tết Đoan Ngọ"
									, "21/6-Ngày Báo Chí Việt Nam"
									, "28/6-Ngày Gia Đình Việt Nam"
									, "27/7-Ngày Thương Binh Liệt Sỹ"
									, "19/8-Ngày CMT8 Thành Công"
									, "2/9-Lễ Quốc Khánh-Đ"
									, "10/10-Ngày Giải Phóng Thủ Đô"
									, "20/11-Ngày Nhà Giáo Việt Nam"
									, "23/11-Ngày Thành Lập Hội Chữ Thập Đỏ"
									, "22/12-Ngày Thành Lập Quân Đội NDVN"};
	String[] ngayLeAm=new String[]{"10/3-Giỗ Tổ Hùng Vương-Đ"
									, "30/12-Giao Thừa-Đ"
									, "1/1-Tết Nguyên Đán-Đ"
									, "2/1-Mùng 2 Tết-Đ"
									, "3/1-Mùng 3 Tết-Đ"
									, "15/7-Lễ Vu Lan"
									, "15/8-Tết Trung Thu"};
	
	public String getNgayLe(objCalendar objdate)
	{
		String le=null;
		for(int i=0;i<ngayLeDuong.length;i++)
		{
			String[] strLe=ngayLeDuong[i].split("-");
			String ngay=objdate.getDaySolar()+"/"+objdate.getMonthSolar();
			if(ngay.equals(strLe[0]))
			{
				if((strLe.length==3))
					red=true;
				
				le=strLe[1];
				break;
			}
		}
		for(int i=0; i<ngayLeAm.length;i++)
		{
			String[] strLe=ngayLeAm[i].split("-");
			String ngay=objdate.getDay()+"/"+objdate.getMonth();
			if(ngay.equals(strLe[0]))
			{
				if(le==null)
					le=strLe[1];
				else
					le+=" và "+strLe[1];
				
				if((strLe.length==3))
					red=true;
				
				break;
			}
		}
		
		return le;
	}
}
