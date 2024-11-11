%边缘检测 使用prewitt算子
I = imread('C:\Users\lenovo\Desktop\hui1.bmp');
BW1 = edge(I,'prewitt',0.04);             % 0.04为梯度阈值ci
figure(1);
imshow(I);
figure(2);
imshow(BW1);