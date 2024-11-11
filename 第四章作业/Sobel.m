
clc
inputFileName = 'C:\Users\lenovo\Desktop\Lena.bmp'
outputFileName = strrep(inputFileName, '.bmp', '.tif')
theImage = imread(inputFileName);
imwrite(theImage, outputFileName);
I=imread('Lena.tif');
figure(1)
subplot(1,2,1)
imshow(I);
title('鍘熷鍥惧儚');
BW=edge(I,'sobel');
subplot(1,2,2)
imshow(BW);
title('杈圭紭妫?娴?')
 
[BW,thresh]=edge(I,'sobel');
disp('Sobel绠楁硶鑷姩閫夋嫨鐨勯槇鍊间负锛?')
disp(thresh);
figure(2)
BW1=edge(I,'sobel',0.02,'horizontal');
subplot(2,2,1)
imshow(BW1);
title('姘村钩鏂瑰悜闃堝?间负0.02')
BW2=edge(I,'sobel',0.02,'vertical');
subplot(2,2,2)
imshow(BW2)
title('鍨傜洿鏂瑰悜闃堝?间负0.02')
BW3=edge(I,'sobel',0.05,'horizontal');
subplot(2,2,3)
imshow(BW3)
title('姘村钩鏂瑰悜闃堝?间负0.05')
BW4=edge(I,'sobel',0.05,'vertical');
subplot(2,2,4)
imshow(BW4)
title('鍨傜洿鏂瑰悜闃堝?间负0.05')