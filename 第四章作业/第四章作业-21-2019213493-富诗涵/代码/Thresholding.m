%%���ַ���ʵ�ֻҶȻ������MATLAB����ʵ�ֻҶȻ�
close all;
clear all;
 
Img=imread('C:\Users\lenovo\Desktop\Lena.bmp');
[n m a]=size(Img);%�ж�ͼ��Ĵ�С
 
GrayImage= rgb2gray(Img);%����MATLAB����ʵ�ֻҶȻ�
 
Img_Gray=zeros(n,m);
for x=1:n%ͨ��˫ѭ����ͼ����лҶȻ�����
    for y=1:m
        % Img_Gray(x,y)=max(Img(x,y,1),max(Img(x,y,2),Img(x,y,3)));  %��һ�ַ���ʵ�ֻҶȻ�
        %Img_Gray(x,y)=(Img(x,y,1)+Img(x,y,2)+Img(x,y,3))/3;%�ڶ��ַ���ʵ�ֻҶȻ�
        Img_Gray(x,y)=0.3*Img(x,y,1)+0.59*Img(x,y,2)+0.11*Img(x,y,3);%�����ַ���ʵ�ֻҶȻ�
        if(Img_Gray(x,y)<100)
            Img_Gray(x,y)=0;
        else
            Img_Gray(x,y)=255;
        end
    end
end
%figure,imshow(Img);title('ԭͼ��')
%figure,imshow(GrayImage);title('����ϵͳ����ʵ�ֻҶȻ�')
figure,imshow(uint8(Img_Gray));title('���ͼƬ')