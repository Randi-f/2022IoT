clear,clc

%% (1) 读取数据
A = imread('Lena.bmp');

%% (2)在数据中加入高斯白噪声作平滑处理
% 加入高斯白噪声
B = double(A)/255;
[m,n,p] = size(B);  % 大小
white_noise = 0 + 0.1*randn(m,n);  % 白噪声
C = B + white_noise;  % 加白噪声
D = C*255;  %将像素范围扩大至0--255
D2 = uint8(D);  % 转为uint8格式

% 平滑处理 
E = medfilt3(D,[7,7,1]);  % 三维中值滤波
E2 = uint8(E);

% 对比结果
figure(1),imshow(A),title('原图');
figure(2),imshow(D2),title('加入均值为0，标准差为0.1的高斯噪声后');
figure(3),imshow(E2),title('对加噪的图形做三维中值滤波后');
