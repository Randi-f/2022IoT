clear,clc
%��ͼ������������ٽ���ƽ������
%% (1) ��ȡ����
A = imread('C:\Users\lenovo\Desktop\Lena.bmp');

%% (2)�������м����˹��������ƽ������
% �����˹������
B = double(A)/255;
[m,n,p] = size(B);  % ��С
white_noise = 0 + 0.1*randn(m,n);  % ������
C = B + white_noise;  % �Ӱ�����
D = C*255;  %�����ط�Χ������0--255
D2 = uint8(D);  % תΪuint8��ʽ

% ƽ������ 
E = medfilt3(D,[7,7,1]);  % ��ά��ֵ�˲�
E2 = uint8(E);

% �ԱȽ��
figure(1),imshow(A),title('ԭͼ');
figure(2),imshow(D2),title('�����ֵΪ0����׼��Ϊ0.1�ĸ�˹������');
figure(3),imshow(E2),title('�Լ����ͼ������ά��ֵ�˲���');
