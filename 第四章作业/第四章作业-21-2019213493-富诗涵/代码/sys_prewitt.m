%��Ե��� ʹ��prewitt����
I = imread('C:\Users\lenovo\Desktop\hui1.bmp');
BW1 = edge(I,'prewitt',0.04);             % 0.04Ϊ�ݶ���ֵci
figure(1);
imshow(I);
figure(2);
imshow(BW1);