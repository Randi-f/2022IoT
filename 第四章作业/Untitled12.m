%自定义边缘检测，想改没改成
clc;
image=imread("lena.bmp");
f=my_edge(image)
figure(1);
imshow(f);

function output = my_edge(input_img)
if size(input_img,3)==3
    input_img=rgb2gray(input_img);
end

input_img=im2double(input_img);
sobel_x=[-1,-2,-1;0,0,0;1,2,1];
sobel_y=[-1,0,1;-2,0,2;-1,0,1];

psf=fspecial('gaussian',[5,5],1);
input_img=imfilter(input_img,psf);%高斯低通滤波，平滑图像,但可能会使图像丢失细节
input_img=medfilt2(input_img); %中值滤波消除孤立点
[m,n]=size(input_img);
output=zeros(m,n);
for i=2:m-1
    for j=2:n-1
        local_img=input_img(i-1:i+1, j-1:j+1);
%近似边缘检测，加快速度    %output(i,j)=abs(sum(sum(sobel_x.*local_img)))+abs(sum(sum(sobel_x.*local_img)));
        output(i,j)=sqrt(sum(sum(sobel_x.*local_img))^2+sum(sum(sobel_y.*local_img))^2);
    end
end

output=imadjust(output);%使边缘图像更明显
thresh=graythresh(output);%确定二值化阈值
output=bwmorph(im2bw(output,thresh),'thin',inf);%强化细节
end