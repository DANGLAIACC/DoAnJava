/*
	use master
	go
	drop database ThiTracNghiem


3 tài khoản được thêm sẵn, có username/password lần lượt là:
1811545103/danglai
tthyen/tthyen
admin/admin
*/

create database ThiTracNghiem
go
use ThiTracNghiem
go
create table Users(
	Username varchar(10) primary key,
	Pwd varchar(60),
	HoTen nvarchar(50),
	Role int
)
go
create table MonHoc(
	MaMH char(12) primary key,
	TenMH nvarchar(200) 
)
go
create table CauHoi(
	MaCH char(12) primary key,
	NoiDung nvarchar(1200),
	DapAn0 nvarchar(400),
	DapAn1 nvarchar(400),
	DapAn2 nvarchar(400),
	DapAn3 nvarchar(400),
	MaMh char(12) foreign key references MonHoc(MaMH)
)
go
create table DeThi(
	MaDT char(4) primary key,
	MaMH char(12) foreign key references MonHoc(MaMH),
	Username varchar(10) foreign key references users(username),
	ThoiGian int -- tính theo phút
)
go
create table CT_DeThi(
	MaDT char(4) foreign key references DeThi(MaDT),
	MaCH char(12) foreign key references CauHoi(MaCH),
	CapDo int
)
go 
create table KetQua(
	MaDT char(4) foreign key references DeThi(MaDT),
	Username varchar(10) foreign key references users(username),
	BatDau datetime,
	KetThuc datetime,
	Diem float,
	primary key (username,batdau)
)

insert into users values
('tthyen','$2a$12$q7ze0LxtK1/M3Jz7ISQFq..xbYWgHskSrea15P4xBeflaagO./Ire',N'Trần Thị Hồng Yến',0),
('admin','$2a$12$7.joQ86yijEUxfOHXQLmku5TrfoPSUcVb6B1Whj5reXvB4AteuetC',N'Quản trị viên',0),
('1811545103','$2a$12$WYTqgAKC.tQhtfB1xLUreO5.QUg9GjdVFzD97.6yFTbbM3hMIkp3W',N'Đặng Quốc Lai',1)

go
insert into MonHoc values
('010107001804',N'Tư tưởng Hồ Chí Minh'),
('010107000217',N'Đường lối cách mạng của Đảng Cộng sản Việt Nam')
go
 
insert into CauHoi (MaCH,NoiDung,DapAn0,DapAn1,DapAn2,DapAn3,MaMh) values
('000000000001', N'Thân phụ Hồ Chí Minh sinh năm bao nhiêu?',N'1862',N'1860',N'1863',N'1883','010107001804'),
('000000000002', N'Thân mẫu Hồ Chí Minh là bà Hoàng Thị Loan. Bà sinh năm nào?',N'1868',N'1866',N'1865',N'1870','010107001804'),
('000000000003', N'Huyện Bình Khê, nơi Cụ Nguyễn Sinh Sắc, thân phụ Hồ Chí Minh có thời kỳ làm tri huyện thuộc tỉnh nào?',N'Bình Định',N'Quảng Nam',N'Quảng Ngãi',N'Phan Thiết','010107001804'),
('000000000004', N'Thân phụ của Hồ Chí Minh là Nguyễn Sinh Sắc, cụ mất vào năm nào?',N'1929',N'1919',N'1939',N'1949','010107001804'),
('000000000005', N'Thân phụ Hồ Chí Minh là Nguyễn Sinh Sắc, Cụ qua đời tại đâu?',N'Cao Lãnh',N'Long Xuyên',N'An Giang',N'Đồng Nai','010107001804'),
('000000000006', N'Thân mẫu Hồ Chí Minh là bà Hoàng Thị Loan, bà mất năm nào?',N'1901',N'1891',N'1911',N'1921','010107001804'),
('000000000007', N'Thân mẫu Hồ  Chí Minh là bà Hoàng Thị Loan, bà mất ở đâu?',N'Huế',N'Nghệ An',N'Hà Tĩnh',N'Bình Định','010107001804'),
('000000000008', N'Thân mẫu Hồ Chí Minh là bà Hoàng Thị Loan, bà sinh được mấy người con?',N'4',N'2',N'3',N'1','010107001804'),
('000000000009', N'Nguyễn Sinh Cung (Hồ Chí Minh) đến Huế lần thứ nhất vào năm nào ?',N'1901',N'1890',N'1902',N'1911','010107001804'),
('000000000010', N'Thân phụ Nguyễn Sinh Sắc làm lễ "vào làng" cho Sinh Cung với tên mới là Nguyễn Tất Thành vào thời gian nào?',N'1901',N'1890',N'1902',N'1911','010107001804'),
('000000000011', N'Nguyễn Tất Thành đến Huế lần thứ 2 năm nào?',N'1906',N'1905',N'1904',N'1908','010107001804'),
('000000000012', N'Người thầy giáo đầu tiên của Nguyễn Tất Thành là ai?',N'Nguyễn Sinh Sắc',N'Vương Thúc Quí',N'Trần Tấn',N'Phan Bội Châu','010107001804'),
('000000000013', N'Nguyễn Tất Thành vào học trường Pháp-Việt Đông Ba vào năm nào?',N'9/1906',N'9/1907',N'9/1908',N'9/1905','010107001804'),
('000000000014', N'Nguyễn Tất Thành học tại ở trường Quốc học Huế năm học nào?',N'Năm học 1907-1908',N'Năm học 1905-1906',N'Năm học 1906-1907',N'Năm học 1911-1912','010107001804'),
('000000000015', N'Nguyễn Tất Thành lần đầu tiên tiếp xúc với khẩu hiệu: "Tự do - Bình đẳng - Bác ái"  vào năm nào?',N'1905',N'1908',N'1917',N'1904','010107001804'),
('000000000016', N'Nguyễn Tất Thành đã tham dự cuộc biểu tình chống thuế của nông dân tỉnh Thừa Thiên vào thời gian nào?',N'5/1908',N'5/1906',N'5/1905',N'5/1911','010107001804'),
('000000000017', N'Nguyễn Tất Thành đến Quy Nhơn học thêm tiếng Pháp từ thời gian nào?',N'9/1909',N'9/1907',N'9/1911',N'9/1912','010107001804'),
('000000000018', N'Nguyễn Tất Thành dạy học ở trường Dục Thanh thời gian nào?',N'9/1910 đến 2/1911',N'9/1908 đến 9/1909',N'9/1910 đến 4/1911',N'9/1910 đến 5/1911','010107001804'),
('000000000019', N'Nguyễn Tất Thành bắt đầu làm việc trên tàu Amiran Latusơ Tơrêvin (Amiral Latouche Trévill) đang cập bến Nhà Rồng Sài Gòn để lấy hàng và đón khách đi Mác-xây khi nào?',N'3/6/1911',N'1/6/1911',N'4/6/1911',N'5/6/1911','010107001804'),
('000000000020', N'Nguyễn Tất Thành ra đi tìm đường cứu nước tại bến cảng Nhà Rồng Sài Gòn đi sang Pháp vào thời gian nào?',N'5/6/1911',N'2/6/1911',N'4/6/1911',N'6/5/1911','010107001804'),
('000000000021', N'Nguyễn Tất Thành lúc ra đi tìm đường cứu nước bao nhiêu tuổi?',N'21 tuổi',N'20 tuổi',N'19 tuổi',N'24 tuổi','010107001804'),
('000000000022', N'Nguyễn Tất Thành lần đầu đặt chân lên đất Pháp là ngày, tháng, năm nào?',N'6/7/1911',N'30/6/1911',N'5/7/1911',N'15/7/1911','010107001804'),
('000000000023', N'Nguyễn Tất Thành nói: "Tôi muốn đi ra ngoài xem nước Pháp và các nước khác làm như thế nào, tôi sẽ trở về giúp đồng bào chúng ta". Câu nói đó vào thời gian nào? ',N'6/1911',N'7/1910',N'6/1909',N'6/1912','010107001804'),
('000000000024', N'Thời gian Nguyễn Ái Quốc viết đơn gửi Tổng thống Pháp và Bộ trưởng bộ thuộc địa trình bày nguyện vọng muốn vào học trường Thuộc địa?',N'Tháng 9/1911',N'Tháng 9/1917',N'Tháng 6/1911',N'Tháng 9/1919','010107001804'),
('000000000025', N'Nguyễn Tất Thành ở Mỹ thời gian nào?',N'1912-1914',N'1912-1913',N'1911-1912',N'1913-1915','010107001804'),
('000000000026', N'Nguyễn Tất Thành ở nước Anh thời gian nào?',N'1914-1917',N'1914-1915',N'1914-1916',N'1913-1914','010107001804'),
('000000000027', N'Trong thời gian ở nước ngoài Nguyễn Tất Thành đã làm những công việc gì?',N'Tất cả các công việc trên',N'Thợ ảnh, làm bánh',N'Đốt lò, bán báo',N'Phụ bếp, cào tuyết','010107001804'),
('000000000028', N'Nguyễn Ái Quốc gửi bản "Yêu sách của nhân dân Việt Nam" tới Hội nghị Véc-xây vào ngày tháng năm nào?',N'18/6/1919',N'18/6/1918',N'18/6/1917',N'18/6/1920','010107001804'),
('000000000029', N'Nguyễn Ái Quốc đọc "Sơ thảo lần thứ nhất Luận cương về vấn đề dân tộc và vấn đề thuộc địa" của Lênin vào  lúc nào?',N'7/1920',N'7/1918',N'7/1917',N'7/1922','010107001804'),
('000000000030', N'Nguyễn Ái Quốc dự Đại hội Tua, tán thành Quốc tế 3, tham gia thành lập Đảng Cộng sản Pháp khi nào?',N'12/1920',N'12/1919',N'12/1918',N'12/1923','010107001804'),
('000000000031', N'Những tri thức mà Nguyễn Tất Thành có được về nền văn hoá Pháp là do anh đã từng đọc các tác phẩm của ai?',N'Tất cả các tác giả trên',N'Rút xô',N'Mông tex kiơ',N'Vôn te','010107001804'),
('000000000032', N'Nguyễn Ái  Quốc tham dự Đại hội lần thứ nhất của Đảng Cộng sản Pháp vào năm nào?',N'1920',N'1919',N'1921',N'1922','010107001804'),
('000000000033', N'Nguyễn Ái Quốc tham dự Đại hội lần thứ hai của Đảng Cộng sản Pháp vào năm nào?',N'1922',N'1921',N'1920',N'1923','010107001804'),
('000000000034', N'Nguyễn Ái Quốc vào Đảng Xã hội Pháp năm nào?',N'1919',N'1918',N'1917',N'1920','010107001804'),
('000000000035', N'Nguyễn Ái Quốc đến ở tại nhà số 9, ngõ Công poanh thuộc quận 17, Pa-ri khi nào?',N'7/1921',N'7/1922',N'7/1923',N'7/1924','010107001804'),
('000000000036', N'Nguyễn Ái Quốc tham gia Ban Nghiên cứu thuộc địa của Đảng Cộng sản Pháp, làm Trưởng tiểu ban Đông Dương năm nào?',N'1922',N'1921',N'1920',N'1923','010107001804'),
('000000000037', N'Nguyễn  Ái Quốc là người Việt Nam thứ mấy tham gia vào Đảng Cộng sản Pháp trong thời gian từ tháng 12/1920 đến tháng 6/1923 ?',N'Thứ nhất',N'Thứ hai',N'Thứ ba',N'Thứ tư','010107001804'),
('000000000038', N'Báo Le Paria do Nguyễn ái Quốc đồng sáng lập, ra số đầu tiên lúc nào?',N'1/4/1922',N'1/4/1921',N'30/12/1920',N'1/4/1923','010107001804'),
('000000000039', N'Nguyễn Tất Thành lấy tên là Nguyễn Ái Quốc vào thời gian nào?',N'18-6-1919',N'18-6-1918',N'18-6-1920',N'18-6-1921','010107001804'),
('000000000040', N'Nguyễn Tất Thành lấy tên là Nguyễn Ái Quốc khi đang ở đâu?',N'Pháp',N'Trung Quốc',N'Anh',N'Liên xô','010107001804'),
('000000000041', N'Truyện ngắn đầu tiên của Nguyễn Ái Quốc nhan đề Pari được đăng trên tờ báo nào?',N'L, Humanité',N'Le Paria',N'Pravđa',N'Công lý','010107001804'),
('000000000042', N'"Luận cương của Lênin làm cho tôi rất cảm động, phấn khởi, sáng tỏ, tin tưởng biết bao. Tôi vui mừng đến phát khóc lên. Ngồi một mình trong buồng mà tôi nói to lên như đang nói trước quần chúng đông đảo: hỡi đồng bào bị đoạ đày đau khổ?". Nguyễn Ái Quốc nói câu ấy khi đang ở đâu?', N'Paris, Pháp',N'Luân Đôn, Anh',N'Quảng Châu, Trung Quốc',N'Máxcơva, Liên Xô','010107001804'),
('000000000043', N'Mùa hè năm 1922 Nguyễn Ái Quốc gặp và làm quen với một số thanh niên Trung Quốc đang học Pari trong đó có:',N'Cả 3 người trên',N'Chu Ân Lai',N'Triệu Thế Viêm',N'Đặng Tiểu Bình','010107001804'),
('000000000044', N'Thay mặt Hội những người Việt Nam yêu nước tại Pháp, Nguyễn Ái Quốc gửi đến Hội nghị Vécxay Bản yêu sách của nhân dân Việt Nam gồm mấy điểm?',N'8 điểm',N'6 điểm',N'9 điểm',N'12 điểm','010107001804'),
('000000000045', N'Vở kịch Con Rồng tre được Nguyễn Ái Quốc viết nhân dịp vua Khải Định sang Pháp, đó là năm nào?',N'Tháng 5/1922',N'Tháng 5/1923',N'Tháng 5/1925',N'Tháng 5/1927','010107001804'),
('000000000046', N'Mùa hè năm 1922 Nguyễn Ái Quốc gặp và làm quen với một số thanh niên Trung Quốc đang học Pari trong đó có:',N'Cả 3 người trên',N'Triệu Thế Viêm',N'Đặng Tiểu Bình',N'Chu Ân Lai','010107001804'),
('000000000047', N'Tác phẩm nào của Nguyễn Ái Quốc viết về sự kiện Khải định sang Pháp năm 1922? ',N'Cả ba tác phẩm trên',N'Vi hành',N'Lời than vãn của bà Trưng Trắc',N'Con Rồng tre','010107001804'),
('000000000048', N'Nguyễn Ái Quốc viết thư gửi Trung ương Đảng Cộng sản Pháp lưu ý cần có sự quan tâm đúng mức đến vấn đề thuộc địa vào thời gian nào?',N'7/1923',N'7/1920',N'7/1918',N'7/ 1930','010107001804'),
('000000000049', N'Nguyễn Ái Quốc là đại biểu duy nhất của nông dân thuộc địa tại Quốc tế nông dân vào thời gian nào?   ',N'10-1923',N'10-1921',N'10-1925',N'10-1927','010107001804'),
('000000000050', N'Nguyễn Ái Quốc đến Liên Xô lần đầu năm nào?',N'1923',N'1922',N'1921',N'1924','010107001804'),
('000000000051', N'Nguyễn Ái Quốc dự Đại hội lần thứ V Quốc tế Cộng sản vào năm nào?',N'1924',N'1923',N'1922',N'1925','010107001804'),
('000000000052', N'Nguyễn Ái Quốc là cán bộ của Ban Phương Đông, Quốc tế cộng sản, được mời đến dự mitting và nói chuyện tại Hồng trường (Maxcova) khi nào?',N'1-5-1924',N'1-5-1925',N'1-5-1923',N'1-5-1926','010107001804'),
('000000000053', N'Nguyễn Ái Quốc học lớp ngắn hạn tại trường đại học Phương đông Liên Xô vào thời gian nào?',N'1923-1924',N'1922-1923',N'1924-1925',N'1925-1926','010107001804'),
('000000000054', N'Năm 1923-1924, tại Liên Xô, Nguyễn Ái Quốc tham dự các Đại hội quốc tế nào?',N'Tất cả các đáp án',N'Quốc tế Nông dân',N'Quốc tế Cộng sản',N'Quốc tế Thanh niên','010107001804'),
('000000000055', N'Nguyễn Ái Quốc viết bài "Lênin và các dân tộc thuộc địa" đăng trên báo nào?',N'Pravda',N'Le Paria',N'Nhân đạo',N'Thanh niên','010107001804'),
('000000000056', N'Nguyễn Ái Quốc viết bài "Lênin và các dân tộc thuộc địa" khi đang  ở đâu?',N'Liên Xô',N'Việt Nam',N'Pháp',N'Trung Quốc','010107001804'),
('000000000057', N'Ngay sau khi tới Quảng Châu, năm 1924, Nguyễn Ái Quốc đã gửi thư về Matxcơva, cho những đâu?',N'Tất cả các nơi trên',N'Tổng thư ký Quốc tế nông dân',N'Ban biên tập tạp chí Rabotnhitxa',N'Quốc tế Cộng sản','010107001804'),
('000000000058', N'Nguyễn Ái Quốc đã tiếp xúc với nhóm "Tâm tâm xã" ở đâu?',N'Quảng Châu, Trung Quốc',N'Thượng Hải, Trung Quốc',N'Hồng Công, Trung Quốc',N'Đông Bắc Thái Lan','010107001804'),
('000000000059', N'Hồ Chí Minh đã cải tổ Tâm Tâm xã thành Hội Việt Nam cách mạng  thanh niên vào năm nào?',N'1925',N'1924',N'1923',N'1927','010107001804'),
('000000000060', N'Trong số các đồng chí sau, ai là người đã được gặp Hồ Chí Minh năm 1925?',N'Hồ Tùng Mậu',N'Phạm Văn Đồng',N'Trần Phú',N'Tôn Đức Thắng','010107001804'),
('000000000061', N'Nguyễn Ái Quốc đã thành lập Hội Việt Nam cách mạng thanh niên vào thời gian nào?',N'6-1925',N'6-1924',N'6-1927',N'6.1929','010107001804'),
('000000000062', N'Nguyễn Ái Quốc đã thành lập Hội Việt Nam cách mạng thanh niên ở đâu?',N'Quảng Châu (Trung Quốc)',N'Hương Cảng (Trung Quốc)',N'Thượng Hải (Trung Quốc)',N'Cao Bằng (Việt Nam)','010107001804'),
('000000000063', N'Tác phẩm "Bản án chế độ thực dân Pháp" được xuất bản lần đầu tiên ở Việt Nam bằng tiếng nào?',N'Tiếng Pháp',N'Tiếng Việt',N'Tiếng Anh',N'Tiếng Nga','010107001804'),
('000000000064', N'Tác phẩm "Bản án chế độ thực dân Pháp" được xuất bản lần đầu tiên ở Việt Nam vào năm nào?',N'1946',N'1941',N'1949',N'1960','010107001804'),
('000000000065', N'Tác phẩm "Bản án chế độ thực dân Pháp" được nhà xuất bản Sự Thật dịch, in  ra tiếng Việt vào năm nào?',N'1960',N'1950',N'1945',N'1965','010107001804'),
('000000000066', N'Bản chất của chủ nghĩa tư bản "là một con đỉa có 1 cái vòi bám vào giai cấp vô sản ở chính quốc và 1 cái vòi khác bám vào giai cấp vô sản ở thuộc địa. Nếu muốn giết con vật ấy, người ta phải đồng thời cắt cả hai vòi. Nếu người ta chỉ cắt một vòi thôi thì cái vòi còn lại kia vẫn tiếp tục hút máu của giai cấp vô sản" câu nói đó từ trong tác phẩm nào của Nguyễn ÁI Quốc?',N'Bản án chế độ thực dân Pháp',N'Con rồng tre',N'Đường cách mệnh',N'Lênin và các dân tộc phương Đông','010107001804'),
('000000000067', N'Nguyễn Ái Quốc tham gia tổ chức "Hội liên hiệp các dân tộc bị áp bức" vào năm nào?',N'1925',N'1922',N'1921',N'1927','010107001804'),
('000000000068', N'Nguyễn Ái Quốc tổ chức "Hội liên hiệp các dân tộc bị áp bức" khi đang ở đâu?',N'Quảng Châu, Trung Quốc',N'Paris, Pháp',N'Cao Bằng, Việt nam',N'U Đon, Thái Lan','010107001804'),
('000000000069', N'Tại Quảng Châu, Trung Quốc, Nguyễn Ái Quốc đã mở nhiều lớp huấn luyện đào tạo cán bộ cho cách mạng Việt Nam, đó là vào những năm nào?',N'1925-1927',N'1924-1926',N'1923-1924',N'1927-1929','010107001804'),
('000000000070', N'Các bài giảng của Nguyễn Ái Quốc tại các lớp huấn luyện cán bộ được Bộ tuyên truyền của Hội liên hiệp các dân tộc bị áp bức tập hợp lại và xuất bản thành tác phẩm gì?',N'Đường kách mệnh',N'Lênin và Phương Đông',N'Con Rồng tre',N'Bản án chế độ thực dân Pháp','010107001804'),
('000000000071', N'Nguyễn Ái Quốc đã trích dẫn luận điểm nổi tiếng của Lênin: "không có lý luận cách mệnh thì không có cách mệnh vận động ... chỉ có theo lý luận cách mệnh tiền phong, Đảng cách mệnh mới làm nối trách nhiệm cách mệnh tiền phong" câu nói được ghi ở trang đầu tiên của cuốn sách nào?',N'Đường cách mạng',N'Bản án chế độ thực dân Pháp',N'Nhật ký trong tù Việt Nam',N'Lênin và các dân tộc thuộc địa','010107001804'),
('000000000072', N'"Công nông là gốc cách mệnh, còn học trò, nhà buôn nhỏ, địa chủ nhỏ, ... là bầu bạn cách mệnh của công nông". Nguyễn Ái Quốc viết câu đó trong tác phẩm nào?',N'Đường cách mệnh',N'Nông dân Trung Quốc',N'Lênin và Phương Đông',N'Bản án chế độ thực dân Pháp','010107001804'),
('000000000073', N'"Chúng ta làm cách mệnh thì cũng phải liên lạc tất cả những đảng cách mệnh trong thế giới để chống lại tư bản và đế quốc chủ nghĩa".  Câu nói đó được Nguyễn Ái Quốc viết trong tác phẩm nào?',N'Đường cách mệnh',N'Bản án chế độ thực dân Pháp',N'Lênin và các dân tộc thuộc địa',N'Trung Quốc và Thanh niên Trung Quốc','010107001804'),
('000000000074', N'"Trước hết phải có Đảng cách mệnh để trong thì vận động và tổ chức dân chúng, ngoài thì liên lạc với dân tộc bị áp bức và vô sản giai cấp mọi nơi." Câu nói đó đựơc Nguyễn Ái Quốc viết  trong tác phẩm nào?',N'Đường cách mệnh',N'Sửa đổi lối làm việc',N'Đây "công lý" của thực dân Pháp ở Đông Dương',N'V.I.Lênin và Phương Đông','010107001804'),
('000000000075', N'"Hai trăm thanh niên trong 1 tỉnh ở Nam kỳ biểu tình trước đồn cảnh sát đòi thả 2 người bạn của họ bị bắt... họ đã thắng lợi. Lần đầu tiên việc đó được thấy ở Đông Dương. Đó là dấu hiệu của thời đại." Câu đó được Nguyễn Ái Quốc viết trong báo cáo hay tác phẩm nào?',N'Báo cáo về tình hình Đông Dương tháng 11 và tháng 12 năm 1924',N'Đường Kách mệnh',N'Bản án chế độ thực dân Pháp',N'Thư gửi Đoàn Chủ tịch Quốc tế Nông dân','010107001804'),
('000000000076', N'Nguyễn Ái Quốc mở lớp huấn luyện chính trị tại số nhà bao nhiêu phố Văn Minh (Quảng Châu)',N'Số 13/1',N'Số 15/l',N'Số 20/1',N'Số 22/1','010107001804'),
('000000000077', N'Tuần báo Thanh Niên, cơ quan trung ương của tổng bộ Việt Nam cách mạng thanh niên do Nguyễn Ái Quốc sáng lập ra số đầu tiên vào thời gian nào?',N'Ngày 21-6-1925',N'Ngày 21-6-1926',N'Ngày 21-6-1924',N'Ngày 21-6-1927','010107001804'),
('000000000078', N'Nguyễn Ái Quốc mang tên Lý Thụy vào thời gian nào?',N'7-1924',N'7-1925',N'7-1943',N'7-1922','010107001804'),
('000000000079', N'Mang tên là Lý Thụy, Nguyễn Ái Quốc đã tham gia lãnh đạo tổ chức quốc tế nào?',N'Hội liên hiệp các dân tộc bị áp bức',N'Hội liên hiệp thuộc địa',N'Tân việt cách mạng Đảng',N'Hội Việt Nam cách mạng thanh niên','010107001804'),
('000000000080', N'Nguyễn Ái Quốc đã dịch và phổ biến bài Quốc tế ca theo thể thơ lục bát vào năm nào?',N'Năm 1925',N'Năm 1921',N'Năm 1929',N'Năm 1945','010107001804'),
('000000000081', N'Nguyễn Ái Quốc đã dịch và phổ biến bài Quốc tế ca theo thể thơ lục bát lúc đang ở đâu?',N'Trung Quốc',N'Pháp',N'Liên xô',N'Việt Nam','010107001804'),
('000000000082', N'Nguyễn Ái Quốc đã gửi thư cho Đại hội đại biểu toàn quốc lần thứ II Quốc dân Đảng Trung Quốc vào năm nào?',N'Năm 1926',N'Năm 1924',N'Năm 1923',N'Năm 1930','010107001804'),
('000000000083', N'Nguyễn Ái Quốc với bí danh Vương Đạt Nhân đã phát biểu tại Đại hội II của Quốc Dân Đảng Trung  Quốc lúc nào?',N'Ngày 14-1-1926',N'Ngày 14-1-1928',N'Ngày 14-1-1924',N'Ngày 14-1-1942','010107001804'),
('000000000084', N'Cuốn "Đường Kách mệnh" tập hợp các bài giảng của Nguyễn Ái Quốc tại các khoá huấn luyện chính trị được xuất bản tại đâu?',N'Trung Quốc',N'Liên-xô',N'Việt Nam',N'Pháp','010107001804'),
('000000000085', N'Nguyễn Ái Quốc chủ trương ra tờ báo "Lính cách mệnh" nhằm tuyên truyền giác ngộ binh lính người Việt Nam khi nào?',N'2/1927',N'2/1947',N'2/1923',N'2/1935','010107001804'),
('000000000086', N'Tư tưởng Hồ Chí Minh về con đường cách mạng Việt Nam được hình thành về cơ bản vào thời gian nào?',N'Năm 1930',N'Năm 1925',N'Năm 1920',N'Năm 1945','010107001804'),
('000000000087', N'Tờ báo "Lính cách mệnh" mà Nguyễn Ái Quốc làm chủ bút có những ai tham gia biên tập viên của tờ báo?',N'Tất cả những người trên',N'Hồ Tùng Mậu',N'Lê Duy Điếm',N'Lê Hồng Sơn','010107001804'),
('000000000088', N'Nguyễn Ái Quốc được Trương Vân Lĩnh, một người Việt Nam tốt nghiệp trường quân sự Hoàng Phố đang làm việc ở sở công an của chính quyền Tưởng Giới Thạch đến báo tin "chúng sắp bắt  anh đấy" vào thời gian nào?',N'5-1927',N'5-1926',N'5-1925',N'5-1928','010107001804'),
('000000000089', N'Cuốn sách "Trung Quốc và thanh niên Trung Quốc" được xuất bản năm nào?',N'1925',N'1924',N'1923',N'1926','010107001804'),
('000000000090', N'Cuốn sách "Trung Quốc và thanh niên Trung Quốc" do Nguyễn Ái Quốc làm chủ biên được viết bằng tiếng gì?',N'Tiếng Pháp',N'Tiếng Nga',N'Tiếng Trung Quốc',N'Tiếng Anh','010107001804'),
('000000000091', N'Cuốn sách "Trung Quốc và thanh niêm Trung Quốc" do Nguyễn Ái Quốc làm chủ biên lần đầu tiên được dịch ra bằng tiếng nước nào?',N'Nga',N'Anh',N'Trung Quốc',N'Tiếng Việt Nam','010107001804'),
('000000000092', N'"Chi có tầng lớp sinh viên là có thể nghe thấy những hồi âm của phong trào cách mạng ở phương Tây. Chỉ có họ mới có thể nhìn thấy, suy ngẫm, so sánh và hiểu vấn đề. Vì vậy, họ là những người đầu tiên tham gia đấu tranh". Nguyễn Ái Quốc viết điều đó trong tác phẩm nào? ',N'Trung Quốc và thanh niên Trung Quốc',N'Đường Kách mệnh',N'Bản án chế độ thực dân Pháp',N'Lênin và Phương Đông','010107001804'),
('000000000093', N'Năm 1925, Nguyễn Ái Quốc đã tổ chức ra nhóm bí mật và chọn 1 số người làm đảng viên dự bị của Cộng sản Đảng. Những người có tên dưới đây ai là đảng viên dự bị của Cộng sản Đảng?',N'Tất cả những người trên',N'Lê Hồng Phong',N'Hồ Tùng Mậu',N'Lê Hồng Sơn','010107001804'),
('000000000094', N'Nguyễn Ái Quốc dự cuộc họp Đại hội đồng của Liên đoàn chống đế quốc, từ ngày 9 đến ngày 12 tháng 12 năm 1927 tại thành phố nào?',N'Brúcxen',N'Mátxcơva',N'Paris',N'Béclin','010107001804'),
('000000000095', N'Nguyễn Ái Quốc viết 1 bức thư gửi cho 1 cán bộ của Quốc tế Cộng sản có đoạn viết "đồng chí có thể hình dung nơi tôi đang sống trong một tình trạng tinh thần và vật chất như thế nào không: biết là có nhiều công việc nhưng không thể làm gì được, ăn không ngồi rồi, không có tiền, sống ngày nào hay ngày ấy mà không được phép hoạt động, vv.." bức thư đó Nguyễn Ái Quốc viết khi nào?',N'4-1928',N'4-1925',N'4-1930',N'4-1937','010107001804'),
('000000000096', N'Nguyễn Ái Quốc được Ban chấp hành Trung ương Quốc tế Cộng sản ra quyết định đồng ý để Người trở về Đông Dương theo nguyện vọng vào thời gian nào? ',N'4-1928',N'4-1924',N'4-1929',N'4-1937','010107001804'),
('000000000097', N'Nguyễn Ái Quốc rời nước Đức đế tìm đường đến Thái Lan khi nào?',N'6- 1928',N'6- 1927',N'6- 1924',N'6- 1929','010107001804'),
('000000000098', N'Nguyễn Ái Quốc từ Italia đáp tàu Nhật Bản đi Xiêm vào thời gian nào?',N'6- 1928',N'6- 1926',N'6- 1929',N'6- 1932','010107001804'),
('000000000099', N'Nguyễn Ái Quốc xuất hiện ở Bản Đông miền trung nước Xiêm vào thời gian nào?',N'7-1928',N'7-1926',N'7-1927',N'7-1925','010107001804'),
('000000000100', N'Tại Thái Lan, Nguyễn Ái Quốc lấy tên là Chín, mọi người tôn trọng gọi là Thầu Chín (Ông già Chín) từ thời gian nào?',N'8/1928',N'8/1927',N'8/1930',N'8/1933','010107001804'),
('000000000101', N'Nguyễn Ái Quốc đã dịch 2 cuốn "Nhân loại tiến hoá sử" và "Cộng sản A.B.C" lúc đang ở Thái Lan, là vào thời gian nào?',N'Năm 1928',N'Năm 1927',N'Năm 1926',N'Năm 1930','010107001804'),
('000000000102', N'Nguyễn Ái Quốc bị toà án Vinh (Nghệ An) xử vắng mặt và bị khép vào tội tử hình vào thời gian nào?',N'10/1929',N'10/1925',N'10/1930',N'10/1932','010107001804'),
('000000000103', N'Nguyễn Ái Quốc rời Xiêm đi Trung Quốc thời gian nào?',N'11/1928',N'11/1929',N'11/1927',N'11/1930','010107001804'),
('000000000104', N'Nguyễn Ái Quốc đến Trung Quốc chuẩn bị cho Hội nghị hợp nhất các Tổ chức Cộng sản Việt Nam vào thời gian nào?',N'12/1929',N'12/1928',N'12/1927',N'12/1930','010107001804'),
('000000000105', N'Theo Hồ Chí Minh , ai "là người đầu tiên đã đặt cơ sở cho một thời đại mới, thật sự cách mạng trong các nước thuộc địa"',N'V.I. Lênin',N'Ph.Ăngghen',N'Các Mác',N'Xtalin','010107001804'),
('000000000106', N'Câu "Cách mệnh là phá cái cũ đổi ra cái mới, cái xấu đổi ra cái tốt". Trích từ tác phẩm nào của Hồ Chí Minh?',N'Đường cách mệnh',N'Bản án chế độ thực dân Pháp',N'Trung Quốc và thanh niên Trung Quốc',N'Đáp án trống','010107001804'),
('000000000107', N'Câu: "Chủ trương làm tư sản dân quyền cách mạng và thổ địa cách mạng để đi tới xã hội cộng sản" được trích từ bài viết nào của Hồ Chí Minh?',N'Chính cương vắn tắt của Đảng',N'Đường cách mệnh',N'Sách lược vắn tắt của Đảng',N'Chương trình tóm tắt của Đảng','010107001804'),
('000000000108', N'Trong Điều lệ vắn tắt của Đảng cộng sản Việt Nam do Nguyễn Ái Quốc soạn thảo, đảng viên có mấy trách nhiệm?',N'5',N'6',N'8',N'4','010107001804'),
('000000000109', N'Ngày 1-5-1930 Nguyễn Ái Quốc hoạt động ở đâu?',N'Xing ga po',N'Xiêm',N'Trung Quốc',N'Liên Xô','010107001804'),
('000000000110', N'Nguyễn Ái Quốc bị bắt ở Hồng Kông lúc nào?',N'6/1931',N'6/1930',N'6/1932',N'6/1933','010107001804'),
('000000000111', N'Khi bị bắt, Hồ Chí Minh mang thẻ căn cước có tên là gì?',N'Tống Văn Sơ',N'Lý Thụy',N'Hồ Quang',N'Thầu Chín','010107001804'),
('000000000112', N'Hồ Chí Minh bị thực dân Anh giam giữ ở Hồng Kông trong thời gian nào',N'6/1931- 1/1933',N'6/1931- 1/1934',N'6/1931- 1/1932',N'6/1931- 1/1935','010107001804'),
('000000000113', N'Ai là người đã có công lớn trong việc cứu Hồ Chí Minh ra khỏi nhà tù của thực dân Anh ở Hồng Kông:',N'Luật sư Lôdơbai (Lôdơbi)',N'Tô mát Xautôn (phó Thống đốc Hồng Kông)',N'Luật sư Nôoen Prit',N'test','010107001804'),
('000000000114', N'Nguyễn Ái Quốc đã viết thư gửi một đồng chí ở Quốc tế cộng sản yêu cầu được giao công việc sau một số năm ở tình trạng không hoạt động, kể từ khi bị Anh bắt giam ở Hồng Kông: Bức thư đó viết lúc nào?',N'6/1938',N'6/1935',N'6/1939',N'6/1941','010107001804'),
('000000000115', N'Đại hội VII Quốc tế cộng sản (6/1935), Hồ Chí Minh đã cùng với đoàn đại biểu Đảng Cộng sản Đông Dương tham dự gồm có những ai:',N'Tất cả những người trên',N'Hoàng Văn Nọn',N'Nguyễn Thị Minh Khai',N'Lê Hồng Phong','010107001804'),
('000000000116', N'Ai là người không phải đại biểu của Đảng Cộng sản Đông Dương tham dự Đại hội VII Quốc tế thanh niên (25/9/1935 tại Maxcova)?',N'Nguyễn Ái Quốc',N'Lê Hồng Phong',N'Nguyễn Thị Minh Khai',N'Huỳnh Văn Nọn','010107001804'),
('000000000117', N'Từ tháng 10-1934 đến hết năm 1935, Hồ Chí Minh học ở trường Quốc tế Lênin. Lúc này, Bác lấy tên là gì?',N'Lin',N'Thầu Chín',N'Vương',N'Hồ Quang','010107001804'),
('000000000118', N'Hồ Chí Minh được tuyển chọn vào lớp nghiên cứu sinh do Viện nghiên cứu các vấn đề dân tộc và thuộc địa mở vào thời gian nào:',N'1/1/1937 - 31/12/1937',N'6/6/1931 - 31/12/1936',N'6/6/1931 - 31/12/1938',N'11/1/1935 – 31/12/1935','010107001804'),
('000000000119', N'Đề tài nghiên cứu của Nguyễn Ái Quốc ở lớp nghiên cứu sinh do Viện Nghiên cứu các vấn đề dân tộc và thuộc địa mở vào năm 1937 là đề tài gì?',N'"Cách mạng ruộng đất ở Đông Nam Á"',N'"Vấn đề thanh niên ở thuộc địa"',N'"Vấn đề cách mạng giải phóng dân tộc ở thuộc địa"',N'"Vấn đề dân tộc thuộc địa"','010107001804'),
('000000000120', N'Nghiên cứu sinh Nguyễn Ai Quốc rời Liên Xô để "về phương Đông" thời gian nào?',N'Tháng 10/1938',N'Tháng 10/1936',N'Tháng 10/1937',N'Tháng 10/1939','010107001804'),
('000000000121', N'Nguyễn Ái Quốc tham gia phong trào cách mạng ở Trung Quốc thời gian nào?',N'10/1938-12/1940',N'10/1938-12/1942',N'10/1938-12/1941',N'10/1938-12/1943','010107001804'),
('000000000122', N'Tham gia giải phóng quân Trung Quốc, với phù hiệu Bát Lộ Quân, Nguyễn Ái Quốc đ-ược phong quân hàm gì?',N'Thiếu tá',N'Trung úy',N'Trung sĩ',N'Thiếu tướng','010107001804'),
('000000000123', N'Cuối 1938, Hồ Chí Minh đã từ Cam Túc (Tây bắc Trung Quốc) xuống Quảng Tây (phía Nam Trung Quốc) trong đoàn quân do ai lãnh đạo?',N'Diệp Kiện Anh',N'Chu Ân Lai',N'Bành Đức Hoài',N'Lưu Thiếu Kỳ','010107001804'),
('000000000124', N'Từ Quảng Tây, Nguyễn Ái Quốc đã liên lạc được với Đảng Cộng sản Đông Dương vào thời gian nào?',N'Tháng 2/1940',N'Tháng 2/1941',N'Tháng 2/1939',N'Tháng 2/1943','010107001804'),
('000000000125', N'Năm 1939, khi còn ở Trung Quốc, Nguyễn Ái Quốc đã viết nhiều bài đăng trên tờ báo công khai của Đảng Cộng sản Đông Dương xuất bản tại Hà Nội từ tháng 1/1939. Đó là báo nào?',N'Tiếng nói của chúng ta',N'Cứu quốc',N'Dân chúng',N'Cờ giải phóng','010107001804'),
('000000000126', N'Năm 1939, sau 2 lần không bắt liên lạc được với Đảng Cộng sản Đông Dương, ở Trung Quốc, Nguyễn Ái Quốc đã làm gì để hi vọng chắp nối được liên lạc?',N'Viết bài đăng báo',N'Gửi thư cho các đồng chí có trách nhiệm',N'Dùng điện đài liên lạc',N'Cử người về bắt liên lạc','010107001804'),
('000000000127', N'Thời kỳ 1939 - 1940, khi hoạt động ở Trung Quốc, Nguyễn Ái Quốc mang bí danh:',N'Vương',N'Lý Thụy',N'Vương Đại Nhân',N'Thọ','010107001804'),
('000000000128', N'Nguyễn Ái Quốc đã tham gia khóa huấn luyện quân sự ở Hàm Dương - Hồ Nam do Quốc dân Đảng và Đảng Cộng sản Trung Quốc hợp tác tổ chức vào thời gian nào?',N'2/1939-9/1939',N'1/1939-7/1939',N'2/1940-8/1940',N'12/1938-6/1939','010107001804'),
('000000000129', N'Đâu tháng 6/1940, Nguyễn Ái Quốc đã cử 2 người đi Diên An học trường quân chính và Người dặn đi dặn lại rằng: "cố gắng học thêm quân sự"?',N'Võ Nguyên Giáp và Phạm Văn Đồng',N'Phùng Chí Kiên và Võ Nguyên Giáp',N'Phạm Văn Đồng và Vũ Anh',N'Hồ Tùng Mậu và Lê Hồng Sơn','010107001804'),
('000000000130', N'Hồ Chí Minh về nước trực tiếp lãnh đạo phong trào cách mạng từ ngày tháng năm?',N'28-1-1941',N'28-1-1940',N'28-1-1939',N'28-1-1942','010107001804'),
('000000000131', N'Địa danh đầu tiên được Hồ Chí Minh đặt chân đến khi mới về nứơc, tại Cột mốc 108 trên biên giới Việt- Trung thuộc huyện nào của tỉnh Cao Bằng?',N'Hà Quảng',N'Hòa An',N'Nguyên Bình',N'Trà Lĩnh','010107001804'),
('000000000132', N'Hồ Chí Minh thí điểm xây dựng Mặt trận Việt Minh đầu tiên ở tỉnh nào?',N'Cao Bằng',N'Tuyên Quang',N'Thái Nguyên',N'Lạng Sơn','010107001804'),
('000000000133', N'Tại Pác Bó, Hồ Chí Minh dịch ra tiếng Việt cuốn sách nào để làm tài liệu huấn luyện cán bộ?',N'Lịch sử Đảng Cộng sản Nga',N'Chiến tranh và Hòa bình',N'Tư bản',N'Đội du kích bí mật','010107001804'),
('000000000134', N'Nguyễn Ái Quốc viết tác phẩm "Lịch sử nước ta" vào năm nào?',N'1941',N'1931',N'1921',N'1951','010107001804'),
('000000000135', N'Về đến Cao Bằng, Nguyễn  Ái Quốc đã dùng bí danh gì để hoạt động cách mạng?',N'Già Thu',N'Thầu Chín',N'Lý Thụy',N'Vương Đạt Nhân','010107001804'),
('000000000136', N'Núi Các Mác, suối Lênin là những ngọn núi, con suối được Hồ Chí Minh đặt tên, hiện nay thuộc huyện, tỉnh nào?',N'Hà Quảng, Cao Bằng',N'Bắc Sơn, Lạng Sơn',N'Sơn Dương, Tuyên Quang',N'Đại Từ, Thái Nguyên','010107001804'),
('000000000137', N'Năm 1941, Nguyễn Ái Quốc viết: "Dân ta phải biết sử ta, Cho tường gốc tích nước nhà Việt Nam", ở trong tác phẩm nào?',N'"Lịch sử nước ta"',N'"Bài ca du kích"',N'"Đường cách mệnh"',N'"Kèn gọi lính"','010107001804'),
('000000000138', N'Hội nghị BCH Trung ương Đảng lần thứ 8, họp 5-1941 do Nguyễn Ái Quốc chủ tọa, có mặt những ai?',N'Trường Chinh, Hoàng Văn Thụ,',N'Nguyễn Văn Cừ, Phan Đăng Lưu,',N'Lê Hồng Phong, Lê Hồng Sơn',N'Hồ Tùng Mậu, Nguyễn Lương Bằng,','010107001804'),
('000000000139', N'"Trong lúc này, quyền lợi của dân tộc là cao hơn hết thảy". Đó là khẳng định của Hội nghị Trương ương nào?',N'Hội nghị TW8 (5/1941)',N'Hội nghị TW6 (l l/1939)',N'Hội nghị TW7 (l l/1940)',N'Hội nghị toàn quốc của Đảng (8/1945)','010107001804'),
('000000000140', N'Theo đề nghị của Nguyễn Ái Quốc, mặt trận dân tộc thống nhất Việt Nam được lấy tên là "Việt Nam độc lập đồng minh", gọi tắt là "Việt Minh". Mặt trận Việt Minh được thành lập khi nào?',N'19-5-1941',N'20-5-1941',N'25-10-1941',N'17-10-1942','010107001804'),
('000000000141', N'Nguyễn Ái Quốc lấy tên mới là Hồ Chí Minh lên đường đi Trung Quốc để liên lạc với các lực lượng đồng minh chống chiến tranh phát xít từ lúc nào?',N'8/1942',N'5/1941',N'5/1943',N'8/1943','010107001804'),
('000000000142', N'Hồ Chí Minh bị chính quyền Quốc dân Đảng Trung Hoa bắt và giam giữ trong thời gian nào?',N'8/1942 - 9/1943',N'8/1942 - 1/1943',N'8/1942 - 6/1943',N'8/1942 - 8/1944','010107001804'),
('000000000143', N'Trong thời gian hơn một năm, chính quyền Tưởng Gới Thạch đã giải Hồ Chí Minh qua mấy nhà tù ở 13 huyện thuộc tỉnh Quảng Tây (Trung quốc)?',N'30 nhà tù',N'20 nhà tù',N'35 nhà tù',N'40 nhà tù','010107001804'),
('000000000144', N'Thời gian bị giam giữ trong các nhà tù ở Quảng Tây, Hồ Chí Minh đã viết tập thơ "Nhật ký trong tù". Tập thơ đó có bao nhiêu bài?',N'134 bài',N'34 bài',N'234 bài',N'334 bài','010107001804'),
('000000000145', N'Bài thơ: "Gạo đem vào giã bao đau đớn; Gạo giã xong rồi, trắng tựa bông. Sống ở trên đời người cũng vậy; Gian nan rèn luyện mới thành công" ở trong tác phẩm nào của Hồ Chí Minh?',N'Nhật ký trong tù',N'Ca binh lính',N'Bài ca du kích',N'Ca sợi chỉ','010107001804'),
('000000000146', N'Ra khỏi nhà tù của Tưởng Giới Thạch, Hồ Chí Minh ở tại Trung Quốc tham gia một số hoạt động của Việt Nam Cách mạng đồng minh hội. Từ khi nào Hồ Chí Minh về Việt Nam:',N'Tháng 9/1944',N'Tháng 4/1944',N'Tháng 7/1944',N'Tháng 2/1944','010107001804'),
('000000000147', N'"Cơ hội cho dân ta giải phóng ở trong một năm hoặc năm rưỡi nữa. Thời gian rất gấp. Ta phải làm nhanh". Câu đó được Hồ Chí Minh nói vào thời gian nào?',N'Tháng 10/1944',N'Tháng 10/1943',N'Tháng 10/1942',N'Tháng 10/1941','010107001804'),
('000000000148', N'Tháng 12/1944, Hồ Chí Minh triệu tập một số cán bộ về Pác Bó (Cao Bằng) để phổ biến chủ trương thành lập Quân giải phóng. Ai là người đã được Hồ Chí Minh chỉ định đảm nhiệm công tác này?',N'Võ Nguyên Giáp',N'Phùng Chí Kiên',N'Vũ Anh',N'Hoàng Văn Thái','010107001804'),
('000000000149', N'Đội Việt Nam tuyên truyền giải phóng quân được thành lập lúc nào?',N'22/12/1944',N'20/12/1944',N'30/12/1944',N'15/5/1945','010107001804'),
('000000000150', N'Hồ Chí Minh lấy bí danh "Ông Ké" từ khi nào?',N'1945',N'1943',N'1944',N'1946','010107001804'),
('000000000151', N'Hồ Chí Minh bắt đầu cuộc hành trình rời Pắc bó về Tân Trào vào ngày tháng năm nào?',N'Ngày 4/5/1945',N'Ngày 4/5/1944',N'Ngày 4/5/1943',N'Ngày 4/5/1942','010107001804'),
('000000000152', N'Hồ Chí Minh, Ban thường vụ TW Đảng và Tổng bộ Việt Minh đã thành lập Uỷ ban khởi nghĩa toàn quốc vào ngày tháng năm nào?',N'13/8/1945',N'9/3/1945',N'19/8/1945',N'28/8/1945','010107001804'),
('000000000153', N'"Toàn quốc đồng bào hãy đứng dậy đem sức ta mà tự giải phóng cho ta". Lời kêu gọi đó của Hồ Chí Minh  là vào thời gian nào?',N'8/1945',N'5/1941',N'9/1945',N'12/1946','010107001804'),
('000000000154', N'Tối ngày 12/8/1945 Hồ Chí Minh nhận được tin Nhật chấp nhận ngừng bắn qua kênh thông tin nào?',N'Đài thu thanh',N'Liên lạc viên',N'Máy bộ đàm',N'Thư','010107001804'),
('000000000155', N'Chủ tịch Hồ Chí Minh  bắt đầu rời Tân Trào về Hà Nội khi nào?',N'Ngày 22/8/1945',N'Ngày 13/8/1945',N'Ngày 15/8/1945',N'Ngày 30/8/1945','010107001804'),
('000000000156', N'"Dù phải đốt cháy cả dãy Trường Sơn cũng phải giành cho được độc lập" câu nói đó của Hồ Chí Minh vào thời gian nào?',N'Tháng 8-1945',N'Tháng 9-1945',N'Tháng 5-1941',N'Tháng 12-1946','010107001804'),
('000000000157', N'Cuối tháng 7/1945, tại lán Nà Lừa, Hồ Chí Minh đã chỉ thị: "Lúc này thời cơ thuận lợi đã tới, dù hi sinh tới đâu, dù phải đốt cháy cả dãy Trường Sơn cũng phải cương quyết giành cho được độc lập". Ai đã được Bác trực tiếp truyền đạt chỉ thị này?',N'Võ Nguyên Giáp',N'Phạm Văn Đồng',N'Đặng Văn Cáp',N'Hoàng Quốc Việt','010107001804'),
('000000000158', N'Ngày 13/8/1945, một cuộc Hội nghị được triệu tập theo đề nghị của Hồ Chí Minh, Hội nghị đã nhận định "Cơ hội rất tốt cho ta giành quyền độc lập đã tới". Đó là hội nghị nào:',N'Hội nghị toàn quốc của Đảng',N'Hội nghị thành lập Khu giải phóng Việt Bắc',N'Hội nghị quân sự Bắc kỳ',N'Đại hội Quốc dân Việt nam','010107001804'),
('000000000159', N'"Hỡi đồng bào yêu quý? Giờ quyết định cho vận mệnh dân tộc đã đến. Toàn quốc đồng bào hãy đứng dậy đem sức ta mà tự giải phóng cho ta".  Đoạn văn trên trích từ văn kiện nào:',N'Lời kêu gọi Tổng khởi nghĩa của Hồ Chí Minh',N'Quân lệnh số 1 của Uỷ ban khởi nghĩa toàn quốc',N'Hiệu triệu Tổng khởi nghĩa của Tổng bộ Việt Minh',N'Lời kêu gọi Toàn quốc kháng chiến của Hồ Chí Minh','010107001804'),
('000000000160', N'Hồ Chí Minh đã soạn thảo Tuyên ngôn Độc lập tại nhà số 48, Hàng Ngang, Hà Nội, vào lúc nào :',N'28-29/8/1945',N'20-22/8/1945',N'22-25/8/1945',N'14-20/8/1945','010107001804'),
('000000000161', N'"Toàn thể dân tộc Việt nam quyết đem tất cả tinh thần và lực lượng, tính mạng và của cải đễ giữ vững quyền tự do, độc lập ấy". Đoạn văn trên trích từ bài viết nào của Hồ Chí Minh:',N'Tuyên ngôn độc lập',N'Lời kêu gọi Toàn quốc kháng chiến',N'Thư  kêu gọi Tổng khởi nghĩa',N'Thư gửi đồng bào Nam bộ','010107001804'),
('000000000162', N'Ngày 8/9/1945 Hồ Chí Minh đã ký sắc lệnh bổ nhiệm ai lam cố vấn Chính phủ lâm thời nước Việt Nam dân chủ cộng hoà?',N'Vĩnh Thuỵ',N'Vũ Hồng Khanh',N'Nguyễn Hải Thần',N'Trần Huy Liệu','010107001804'),
('000000000163', N'Ngày 11/10/1945 Chủ tịch Hồ Chí Minh đã dự Lễ lên đường của đoàn quân tiễu trừ giặc đói diễn ra ở đâu?',N'Nhà hát lớn Hà Nội',N'Bắc Bộ phủ, Hà Nội',N'Trường Đại học Việt Nam, Hà Nội',N'Ga Hàng Cỏ, Hà Nội','010107001804'),
('000000000164', N'Ủy ban dự thảo Hiến pháp đầu tiên của nước Việt Nam Dân chủ Cộng hòa do ai làm Trưởng ban:',N'Hồ Chí Minh',N'Đặng Xuân Khu',N'Nguyễn Lương Bằng',N'Lê Văn Hiến','010107001804'),
('000000000165', N'Bác Hồ viết: "Nay chúng ta đã giành đựơc quyền độc lập, một trong những công việc phải thực hiện cấp tốc trong lúc này, là nâng cao dân trí... . Phụ nữ lại càng cần phải học, đã lâu chị em bị kìm hãm, đây là lúc chị em phải cố gắng để kịp nam giới". Đoạn văn trên trích từ văn bản nào của Hồ Chí Minh',N'Chống nạn thất học',N'Sắc lệnh thành lập Nha bình dân học vụ',N'Sắc lệnh thiết lập Hội đồng cố vấn học chính',N'Đời sống mới','010107001804'),
('000000000166', N'Chính phủ lâm thời nước Việt Nam dân chủ cộng hòa ban hành Sắc lệnh thành lập Nha bình dân học vụ lúc nào?',N'6/9/1945',N'4/10/1945',N'19/8/1945',N'26/9/1945','010107001804'),
('000000000167', N'Trong phiên họp đầu tiên của Hội đồng Chính phủ nước Việt Nam dân chủ cộng hòa, dưới sự chủ tọa của Hồ Chí Minh, Người đã nói: "Nạn dốt là một trong những phương pháp độc ác mà bọn thực dân dùng để cai trị chúng ta. Hơn chín mươi phần trăm đồng bào chúng ta mù chữ... Một dân tộc dốt là một dân tộc yếu. Vì vậy tôi đề nghị mở một chiến dịch để chống nạn mù chữ". Phiên họp đó diễn ra lúc nào?',N'3/9/1945',N'6/9/1945',N'8/9/1945',N'10/9/1945','010107001804'),
('000000000168', N'Sáng ngày 3/9/1945 Chủ tịch Hồ Chí Minh chủ toạ phiên họp đầu tiên của Hội đồng Chính phủ nước Việt Nam dân chủ cộng hoà ở đâu?',N'Bắc Bộ phủ',N'Phủ Chủ tịch',N'Nhà hát lớn',N'Đình làng Đình Bảng','010107001804'),
('000000000169', N'Ngày 3/9/1945, trong phiên họp đầu tiên của Chính phủ, Hồ Chí Minh nêu 6 vấn đề cấp bách,... Theo anh (chị) vấn đề thứ 6 là gì?',N'Chính phủ ban hành chính sách tôn trọng tự do tín ngưỡng và kêu gọi nhân dân lương giáo đoàn kết',N'Phát động phong trào quyên góp, cứu tế, "hũ gạo tiết kiệm" và "tuần lễ vàng" giúp Chính phủ',N'Chính phủ ban hành chính sách đoàn kết quốc tế, tranh thủ sự ủng hộ giúp đỡ của nhân dân tiến bộ trên toàn thế giới',N'Ban hành chính sách quốc hữu hoá và hợp tác hoá tư liệu sản xuất','010107001804'),
('000000000170', N'"Chúng ta chỉ đòi quyền độc lập tự do, chứ chúng ta không vì tư thù tư oán, làm cho thế giới biết rằng chúng ta là một dân tộc văn minh, văn minh hơn bọn đi giết người cướp nước". Đây là đoạn văn trích trong bức thư nào của Hồ Chí Minh',N'Thư gửi đồng bào Nam bộ, ngày 01/06/1946',N'Thư gửi uỷ ban nhân dân các kỳ, tỉnh, huyện và làng, 10-1945',N'Gửi đồng bào Nam bộ, ngày 26/09//945',N'Thư gửi cáchọc sinh tháng 09/1945','010107001804'),
('000000000171', N'Ai là người đi đầu trong việc quyên góp ủng hộ Chính phủ trong "Tuần lễ vàng" đã được Hồ Chí Minh tặng thưởng huy chương vàng?',N'Vương Thị Lai',N'Bạch Thái Bưởi',N'Nguyễn Sơn Hà',N'Trịnh Văn Bô','010107001804'),
('000000000172', N'Câu nói: "Cứ 10 ngày nhịn ăn một bữa, mỗi tháng nhịn ba bữa. Đem gạo đó (mỗi bữa một bơ) để cứu dân nghèo" được trích trong thư Bác Hồ gửi đồng bào toàn quốc kêu gọi ra sức cứu đối vào ngày tháng năm nào?',N'28/9/1945',N'23/9/1945',N'5/9/1945',N'6/1/1946','010107001804'),
('000000000173', N'Ngày 15/11/1945, Bác Hồ đã dự lễ khai giảng khóa đầu tiên của trường đại học nào?',N'Đại học Y khoa Hà Nội',N'Đại học Bách khoa Hà Nội',N'Đại học Việt Nam',N'Đại học Sư phạm Hà Nội','010107001804'),
('000000000174', N'Ngày 29/9/1945, Chủ tịch Hồ Chí Minh đã ký sắc lệnh số 40 về việc lập thêm một Toà án quân sự ở đâu?',N'Nha Trang',N'Đà Nẵng',N'Hải Phòng',N'Sài Gòn','010107001804'),
('000000000175', N'"Đã hơn một tháng nay, anh chị em đã chiến đấu cực kỳ anh dũng. Toàn thể đồng bào Việt Nam đều cảm động. Những gương hi sinh anh dũng của các bạn đã sáng dọi khắp nước Những chiến công oanh liệt của các bạn đã làm cho toàn thể đồng bào thêm kiên quyết". Đoạn trích này trong thư Hồ Chí Minh gửi cho nơi nào?',N'Thanh niên Nam bộ',N'Đồng bào Tây Nguyên',N'Nhân dân Hải Phòng',N'Nhân dân Gài Gòn- Gia Định','010107001804'),
('000000000176', N'Chủ tịch Hồ Chí Minh thay mặt chính phủ tặng đồng bào miền Nam danh hiệu gì tháng 12/1946?',N'Thành đồng Tổ quốc',N'Sản xuất giỏi',N'Kháng chiến anh dũng',N'Tất cả danh hiệu trên','010107001804'),
('000000000177', N'Hồ Chí Minh thành lập Chính phủ Liên hiệp lâm thời và cùng Chính phủ ra mắt đồng bào vào thời gian nào?',N'1/1/1946',N'6/1/1946',N'2/3/1946',N'5/11/1946','010107001804'),
('000000000178', N'Năm 1946, Hồ Chí Minh đã đón ai là người nhà từ Nghệ An ra thăm?',N'Cả hai người trên',N'Ông Nguyễn Sinh Khiêm',N'Nguyễn Thị Thanh',N'Không có ai','010107001804'),
('000000000179', N'Trong lời kêu gọi quốc dân đi bỏ phiếu, Hồ Chí Minh viết: " Ngày mai, là một ngày cả quốc dân ta lên con đường mới mẻ ... vì ngày mai là ngày Tổng tuyển cử, vì ngày mai là một ngày đầu tiên trong lịch sử Việt Nam nhân dân ta bắt đầu hưởng dụng quyền dân chủ của mình".  Lời kêu gọi đó được Hồ Chí Minh viết vào này nào lúc nào',N'Ngày 5/1/1946',N'Ngày 6/1/1946',N'Ngày 1/1/1946',N'Ngày 19/12/1946','010107001804'),
('000000000180', N'Ngày 1/1/1946, Hồ Chí Minh thành lập Chính phủ liên hiệp lâm thời và cùng Chính phủ ra mắt đồng bào ở đâu?',N'Nhà hát lớn',N'Bắc Bộ phủ',N'Quảng trường Ba Đình',N'Phủ Chủ tịch','010107001804'),
('000000000181', N'Mùa xuân 1946, nói chuyện với linh mục Hồ Ngọc Cẩm (giáo phận Bắc Ninh), Hồ Chí Minh có nhắc đến một giáo dân yêu nước: "Tuy ông được sang Pháp học tập, lại từng làm việc cho Soái phủ Pháp mấy năm ở Sài Gòn. Thế mà ông ta đã gửi lên triều đình Tự Đức nhiều bản sớ tấu bàn việc chỉnh tu võ bị, canh tân đất nước. Ngày ấy, triều đình không lắng nghe ông ta. Giá như biết làm theo một số điều kiến nghị ấy thì chắc cũng đã bớt được nhiều khó khăn". Giáo dân ấy là ai?',N'Nguyễn Trường Tộ',N'Nguyễn Xuân Ôn',N'Bùi Viện',N'Nguyễn Trọng Hợp','010107001804'),
('000000000182', N'Ai là người được Chủ tịch Hồ Chí Minh uỷ nhiệm vào Nam bộ với đoàn đại biểu Pháp để giải thích và thi hành Hiệp định Sơ bộ 6/3/1946?',N'Hoàng Quốc Việt và Huỳnh Văn Tiểng',N'Hoàng Quốc Việt',N'Huỳnh Văn Tiểng',N'Phạm Văn Đồng','010107001804'),
('000000000183', N'Hồ Chí Minh cùng đại diện Việt Nam Quốc dân Đảng ký cam kết "Tinh thần đoàn kết" khi nào?',N'24/11/1945',N'19/12/1946',N'23/9/1945',N'12/12/1945','010107001804'),
('000000000184', N'Hồ Chí Minh nói: "Tôi chỉ có một sự ham muốn, ham muốn tột bậc, là làm sao cho nước ta được hoàn toàn độc lập, dân ta hoàn toàn được tự do, đồng bào ai cũng có cơm ăn. áo mặc, ai cũng được học hành" vào ngày tháng năm nào?',N'21/11/1946',N'19/5/1954',N'19/5/1960',N'19/5/1969','010107001804'),
('000000000185', N'"Tôi có thể tuyên bố trước Quốc hội rằng, Chính phủ này tỏ rõ cái tinh thần quốc dân liên hiệp... Chính phủ này là Chính phủ toàn quốc, có đủ nhân tài Trung, Nam, Bắc tham gia". Đó là lời tuyên bố của Hồ Chí Minh sau khi thành lập Chính phủ mới, không có bọn phản động tham gia. Chính phủ đó được thành lập lúc nào?',N'Tháng 11/1946',N'Tháng 3/1946',N'Tháng 12/1945',N'Tháng 9/1945','010107001804'),
('000000000186', N'"Hiến pháp đó tuyên bố với thế giới Việt Nam đã được độc lập..." đó là lời phát biểu của Hồ Chí Minh trong kỳ họp thứ 2 quốc hội khóa I thông qua hiến pháp đầu tiên của nước ta khi nào?',N'11/1946',N'1/1946',N'3/1946',N'12/1946','010107001804'),
('000000000187', N'"Đồng bào Nam bộ là dân nước Việt nam. Sông có thể cạn, núi có thể mòn, song chân lý đó không bao giờ thay đổi!" Câu nói này của Hồ Chí Minh được trích ra từ văn kiện nào',N'Thư đồng bào Nam bộ 31/5/1946',N'Bài nói chuyện cùng đồng bào trước khi sang Pháp',N'Lời kêu gọi Kiều bào Việt Nam ở Pháp',N'Trả lời phóng viên Hãng thông tấn A.F.P','010107001804'),
('000000000188', N'"Cả đời tôi chỉ có một mục đích, là phấn đấu cho quyền lợi Tổ quốc, và hạnh phúc của quốc dân.... Bất kỳ bao giờ, bất kỳ ở đâu, tôi cũng chỉ theo đuổi một mục đích, làm cho ích quốc lợi dân". Câu nói trên trích từ bài nói chuyện của Hồ Chí Minh trước khi Người sang thăm nước Pháp. Buổi mít tinh đó được tổ chức tại Hà Nội ngày nào:',N'30/5/1946',N'1/6/1946',N'29/5/1946',N'31/5/1946','010107001804'),
('000000000189', N'Ngày 27/5/1946, Hội đồng Chính phủ đã quyết định chọn ai thay Hồ Chí Minh giữ chức vụ Chủ tịch nước trong thời gian Người đi vắng?',N'Huỳnh Thúc Kháng',N'Phan Anh',N'Phạm Văn Đồng',N'Võ Nguyên Giáp','010107001804'),
('000000000190', N'Năm 1946, Huỳnh Thúc Kháng thay mặt Hồ Chí Minh giữ chức vụ Chủ Tịch nước khi Hồ Chí Minh đi đâu?',N'Pháp',N'Trung Quốc',N'Liên Xô',N'Ấn Độ','010107001804'),
('000000000191', N'Trong thời gian Hồ Chí Minh đi Pháp (1946), ai đã lập ra "Chính phủ lâm thời của nước Cộng hoà Nam kỳ"?',N'Đácgiăngliơ',N'Nguyễn Hải Thần',N'Raun Xalăng',N'Bảo Đại','010107001804'),
('000000000192', N'Trong thời gian Hồ Chí Minh ở Pháp, Người không làm gì trong các việc sau:',N'Dự hội nghị Phôngtennơblô',N'Tuyên truyền Việt Nam đã độc lập',N'Gặp gỡ kiều bào ở Pháp',N'Hội đàm với chính phủ Pháp','010107001804'),
('000000000193', N'Chủ tịch Hồ Chí Minh đọc diễn văn kỷ niệm Quốc khánh đầu tiên của nước Việt Nam dân chủ cộng hoà ở đâu?',N'Paris',N'Hà Nội',N'Hải Phòng',N'Tân Trào','010107001804'),
('000000000194', N'Để tìm kiếm nhân tài cho đất nước Hồ Chí Minh đã viết bài Tìm người tài đức trong đó có đoạn: "E vì Chính phủ không nghe đến, không nhìn khắp, đến nỗi các bậc tài đức không thể xuất thân". Hãy cho biết bài báo này được đăng trên tờ báo nào?',N'Báo Cứu quốc',N'Báo Thanh niên',N'Báo Phụ nữ',N'Báo Sự Thật','010107001804'),
('000000000195', N'Tháng 12 năm 1946, Chủ tịch Hồ Chí Minh đã giao nhiệm vụ cho ai lên Việt Bắc chuẩn bị căn cứ  để di chuyển cơ quan lãnh đạo Đảng và Nhà nước khi cần thiết?',N'Nguyễn Lương Bằng',N'Hoàng Văn Thái',N'Nguyễn Văn Huyên',N'Nguyễn Văn Tố','010107001804'),
('000000000196', N'Chủ tịch Hồ Chí Minh bắt đầu chuyển đến ở và làm việc tại làng Vạn Phúc, Hà Đông từ khi nào?',N'Ngày 3/12/1946',N'Ngày 22/12/1946',N'Ngày 6/1/1946',N'Ngày 10/9/1947','010107001804'),
('000000000197', N'Ngày 24/12/1945 Chủ tịch Hồ Chí Minh đã gặp ai để thoả thuận những điều kiện hợp tác giữa Việt Minh và Việt Nam Quốc dân Đảng?',N'Hai người A và B',N'Tiêu Văn',N'Vũ Hồng Khanh',N'Nguyễn Hải Thần','010107001804'),
('000000000198', N'Ngày 5/1/1946 Chủ tịch Hồ Chí Minh đã dự lễ mít tinh của hơn hai vạn đồng bào Hà Nội ủng hộ cuộc bầu cử Quốc hội. Cuộc mít tinh đó diễn ra ở đâu?',N'Khu Việt Nam học xá',N'Nhà hát lớn',N'Quảng trường Ba Đình',N'Sân ga Hàng Cỏ','010107001804'),
('000000000199', N'Ngày 28/1/1946, Hồ Chí Minh viết một bài đăng báo Cứu quốc, có đoạn viết: "Tôi phải nói thật: những sự thành công là nhờ các đồng chí cố gắng. Những khuyết điểm kể trên là lỗi tại tôi. Người đời không phải thánh thần, không ai tránh khỏi khuyết điểm. Chúng ta không sợ có khuyết điểm, Nhưng chỉ sợ không biết kiên quyết sửa nó đi". Bài báo đó có tên là gì?',N'Tự phê bình',N'Lời khuyên anh em viên chức',N'Lời cảm ơn đồng bào',N'Lời căn dặn cán bộ tuyên truyền','010107001804'),
('000000000200', N'"Một năm khởi đầu từ mùa xuân. Một đời khởi đầu từ tuổi trẻ. Tuổi trẻ là mùa xuân của xã hội". Đây là đoạn trích trong thư Bác Hồ gửi cho thanh niên và nhi đồng toàn quốc nhân dịp Tết năm nào?',N'1946',N'1945',N'1950',N'Cả ba đều sai','010107001804')

go
insert into DeThi values
('0000','010107001804','tthyen',90),
('0001','010107001804','tthyen',45)
go

insert into CT_DeThi values
('0000', '000000000002',0),
('0000', '000000000003',0),
('0000', '000000000007',2),
('0000', '000000000010',0),
('0000', '000000000014',0),
('0000', '000000000015',2),
('0000', '000000000018',0),
('0000', '000000000022',0),
('0000', '000000000024',2),
('0000', '000000000028',0),
('0000', '000000000029',2),
('0000', '000000000031',1),
('0000', '000000000032',2),
('0000', '000000000036',1),
('0000', '000000000040',2),
('0000', '000000000042',0),
('0000', '000000000044',0),
('0000', '000000000045',2),
('0000', '000000000047',0),
('0000', '000000000048',2),
('0000', '000000000049',0),
('0000', '000000000050',0),
('0000', '000000000054',2),
('0000', '000000000056',1),
('0000', '000000000058',2),
('0000', '000000000059',2),
('0000', '000000000062',2),
('0000', '000000000065',1),
('0000', '000000000068',2),
('0000', '000000000071',0),
('0000', '000000000072',0),
('0000', '000000000075',2),
('0000', '000000000076',1),
('0000', '000000000077',0),
('0000', '000000000078',2),
('0000', '000000000080',0),
('0000', '000000000083',1),
('0000', '000000000085',2),
('0000', '000000000089',1),
('0000', '000000000092',0),
('0000', '000000000096',0),
('0000', '000000000097',2),
('0000', '000000000101',1),
('0000', '000000000102',2),
('0000', '000000000105',0),
('0000', '000000000109',1),
('0000', '000000000110',0),
('0000', '000000000114',2),
('0000', '000000000116',1),
('0000', '000000000118',0),
('0000', '000000000121',0),
('0000', '000000000124',0),
('0000', '000000000125',2),
('0000', '000000000129',0),
('0000', '000000000130',2),
('0000', '000000000131',0),
('0000', '000000000133',1),
('0000', '000000000137',0),
('0000', '000000000139',0),
('0000', '000000000141',2),
('0000', '000000000142',2),
('0000', '000000000145',2),
('0000', '000000000149',2),
('0000', '000000000152',1),
('0000', '000000000155',1),
('0000', '000000000158',1),
('0000', '000000000160',1),
('0000', '000000000161',2),
('0000', '000000000164',0),
('0000', '000000000167',2),
('0000', '000000000171',2),
('0000', '000000000174',0),
('0000', '000000000176',0),
('0000', '000000000180',2),
('0000', '000000000182',2),
('0000', '000000000184',2),
('0000', '000000000185',1),
('0000', '000000000186',1),
('0000', '000000000188',0),
('0000', '000000000192',0),
('0000', '000000000194',2),
('0000', '000000000196',0),
('0000', '000000000200',1),
('0000', '000000000103',1),
('0000', '000000000104',3),
('0000', '000000000108',3),
('0000', '000000000111',3),
('0000', '000000000113',3),
('0000', '000000000117',3),
('0000', '000000000120',3),
('0001', '000000000003',2),
('0001', '000000000006',0),
('0001', '000000000008',0),
('0001', '000000000012',1),
('0001', '000000000015',2),
('0001', '000000000017',0),
('0001', '000000000018',0),
('0001', '000000000022',1),
('0001', '000000000026',1),
('0001', '000000000030',2),
('0001', '000000000034',1),
('0001', '000000000037',0),
('0001', '000000000038',1),
('0001', '000000000040',2),
('0001', '000000000041',1),
('0001', '000000000042',0),
('0001', '000000000043',1),
('0001', '000000000044',0),
('0001', '000000000045',2),
('0001', '000000000046',0),
('0001', '000000000047',1),
('0001', '000000000049',0),
('0001', '000000000053',0),
('0001', '000000000055',1),
('0001', '000000000057',1),
('0001', '000000000059',0),
('0001', '000000000062',0),
('0001', '000000000063',2),
('0001', '000000000067',2),
('0001', '000000000070',1),
('0001', '000000000072',3),
('0001', '000000000076',3),
('0001', '000000000079',3),
('0001', '000000000082',3),
('0001', '000000000085',3),
('0001', '000000000086',3),
('0001', '000000000088',3),
('0001', '000000000089',1),
('0001', '000000000091',0),
('0001', '000000000095',1),
('0001', '000000000097',1),
('0001', '000000000099',2),
('0001', '000000000102',1),
('0001', '000000000106',2),
('0001', '000000000109',2)
go

create proc procCauHoi(
	@MaCH char(12), @NoiDung nvarchar(1200), @DapAn0 nvarchar(400), @DapAn1 nvarchar(400),
	@DapAn2 nvarchar(400), @DapAn3 nvarchar(400), @MaMH char(12), @MaDT char(4),@CapDo int
) as
begin 
	if exists ( select MaCH from CauHoi where MaCH = @MaCH)
		update CauHoi
		set NoiDung = @NoiDung, DapAn0 = @DapAn0, DapAn1 = @DapAn1, DapAn2 = @DapAn2,
			DapAn3 = @DapAn3, MaMh = @MaMH where MaCH = @MaCH
	else
	begin
		insert into CauHoi values
		(@MaCH,@NoiDung,@DapAn0,
		@DapAn1,@DapAn2,@DapAn3,@MaMH)

		insert into CT_DeThi values
		(@MaDT,@MaCH,@CapDo)
	end
end

go

create proc procDeThi(@MaDT char(4), @MaMH char(12), @Username char(10), @ThoiGian int) 
as begin
	if exists (select MaDT from DeThi where MaDT = @MaDT)
		update DeThi set MaMH = @MaMH, Username = @Username, ThoiGian = @ThoiGian
		where MaDT = @MaDT
	else
		insert into DeThi values (@MaDT,@MaMH,@Username,@ThoiGian)
end

go

select * from DeThi 

