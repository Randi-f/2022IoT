%直方图均衡化，自己定义函数
clc;
image=imread("C:\Users\lenovo\Desktop\Lena.bmp");
f=hist_equal(image)
function f=hist_equal(image)
[m,n]=size(image);%获得图像数据尺寸
count=zeros(1,256);%均衡前每级灰度出现个数
countk=zeros(1,256);%均衡前每级灰度出现概率
gray=zeros(1,256);%均衡化灰度出现个数
grayk=zeros(1,256);%均衡化灰度出现概率
gpeq=zeros(1,256);%均衡化后灰度值统计
gpeqk=zeros(1,256);%均衡化后灰度出现概率
%初始图像数据
for k=0:255
    count(k+1)=length(find(image==k));%每级灰度出现个数
    countk(k+1)=count(k+1)/(m*n);%每级灰度出现概率
end
%直方图均衡化
grayk(1)=countk(1);
for i=2:256
    grayk(i)=grayk(i-1)+countk(i);
end
gray=round(grayk*256);
for i=1:256
gpeq(i)=sum(count(find(gray==i)));%计算每个灰度值出现的概率
gpeqk(i)=sum(countk(find(gray==i)));%计算每个灰度值出现的概率
end
%图像均衡化
image_new=image;
for i=0:255
    image_new(find(image==i))=gray(i+1);
end
%显示图像
figure(1);
subplot(231);
imshow(image);
title('原始图像')

subplot(234);
xlabel('灰度值')
ylabel('出现频率')
bar(0:255,count)
title('原图像直方图')

subplot(232)
imshow(image_new)
title('均衡化后图像')

subplot(235)
xlabel('灰度值')
ylabel('出现频率')
bar(0:255,gpeq)
title('均衡化后直方图')

end
