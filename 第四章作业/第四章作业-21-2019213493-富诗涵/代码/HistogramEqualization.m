%ֱ��ͼ���⻯���Լ����庯��
clc;
image=imread("C:\Users\lenovo\Desktop\Lena.bmp");
f=hist_equal(image)
function f=hist_equal(image)
[m,n]=size(image);%���ͼ�����ݳߴ�
count=zeros(1,256);%����ǰÿ���Ҷȳ��ָ���
countk=zeros(1,256);%����ǰÿ���Ҷȳ��ָ���
gray=zeros(1,256);%���⻯�Ҷȳ��ָ���
grayk=zeros(1,256);%���⻯�Ҷȳ��ָ���
gpeq=zeros(1,256);%���⻯��Ҷ�ֵͳ��
gpeqk=zeros(1,256);%���⻯��Ҷȳ��ָ���
%��ʼͼ������
for k=0:255
    count(k+1)=length(find(image==k));%ÿ���Ҷȳ��ָ���
    countk(k+1)=count(k+1)/(m*n);%ÿ���Ҷȳ��ָ���
end
%ֱ��ͼ���⻯
grayk(1)=countk(1);
for i=2:256
    grayk(i)=grayk(i-1)+countk(i);
end
gray=round(grayk*256);
for i=1:256
gpeq(i)=sum(count(find(gray==i)));%����ÿ���Ҷ�ֵ���ֵĸ���
gpeqk(i)=sum(countk(find(gray==i)));%����ÿ���Ҷ�ֵ���ֵĸ���
end
%ͼ����⻯
image_new=image;
for i=0:255
    image_new(find(image==i))=gray(i+1);
end
%��ʾͼ��
figure(1);
subplot(231);
imshow(image);
title('ԭʼͼ��')

subplot(234);
xlabel('�Ҷ�ֵ')
ylabel('����Ƶ��')
bar(0:255,count)
title('ԭͼ��ֱ��ͼ')

subplot(232)
imshow(image_new)
title('���⻯��ͼ��')

subplot(235)
xlabel('�Ҷ�ֵ')
ylabel('����Ƶ��')
bar(0:255,gpeq)
title('���⻯��ֱ��ͼ')

end
