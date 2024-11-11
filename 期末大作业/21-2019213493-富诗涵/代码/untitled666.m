function varargout = untitled666(varargin)
% UNTITLED666 MATLAB code for untitled666.fig
%      UNTITLED666, by itself, creates a new UNTITLED666 or raises the existing
%      singleton*.
%
%      H = UNTITLED666 returns the handle to a new UNTITLED666 or the handle to
%      the existing singleton*.
%
%      UNTITLED666('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in UNTITLED666.M with the given input arguments.
%
%      UNTITLED666('Property','Value',...) creates a new UNTITLED666 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before untitled666_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to untitled666_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help untitled666

% Last Modified by GUIDE v2.5 01-Jul-2022 10:12:55

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @untitled666_OpeningFcn, ...
                   'gui_OutputFcn',  @untitled666_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT

%untitled666
% --- Executes just before untitled666 is made visible.
function untitled666_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to untitled666 (see VARARGIN)

% Choose default command line output for untitled666
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes untitled666 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = untitled666_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
axis off  %%关闭坐标轴显示
%%filename存放打开的文件名  pathname存放路径
[filename pathname] =uigetfile({'*.jpg';'*.bmp';'*.*'},'打开图片');
%%字符串拼接 拼装路径 
str=[pathname filename];
%%打开图像
im=imread(str);
%%打开axes1的句柄 进行axes1的操作
axes(handles.axes1);
%%在axes1中显示 图像
imshow(im);
f=my_edge(im);
axes(handles.axes2);
imshow(f);

% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
axis off  
%%filename存放打开的文件名  pathname存放路径
[filename pathname] =uigetfile({'*.jpg';'*.bmp';'*.*'},'打开图片');
str=[pathname filename];
im=imread(str);
axes(handles.axes1);
imshow(im);
f=my_color(im);
axes(handles.axes2);
imshow(f);

% --- Executes on button press in pushbutton3.
function pushbutton3_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
axis off 
[filename pathname] =uigetfile({'*.jpg';'*.bmp';'*.*'},'打开图片');
str=[pathname filename];
im=imread(str);
axes(handles.axes1);
imshow(im);
f=my_Caricature(im);
axes(handles.axes2);
imshow(f);

function output = my_color(img)
% Key arguments -- please determine them according to specific images.
% Threshold for edge determining.
saturation_scalar = 2;
% Arguments for Bilateral filter.
radius=10; sigma=[3, 0.1]; 
% Adjust the saturation of img.
img_sa = saturation_adjust(img, saturation_scalar);
% Normalize image to [0,1].
img_f = (double(img_sa)) ./ 255;
img_f = bfilter2(img_f,radius,sigma);
output=img_f;

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
        output(i,j)=sqrt(sum(sum(sobel_x.*local_img))^2+sum(sum(sobel_y.*local_img))^2);
    end
end
output=imadjust(output);%使边缘图像更明显
thresh=graythresh(output);%确定二值化阈值
output=bwmorph(im2bw(output,thresh),'thin',inf);%强化细节

function output = my_Caricature(img)
% Key arguments -- please determine them according to specific images.
% Threshold for edge determining.
edge_thresh = 0.02;
edge_operator = 'sobel'; 
saturation_scalar = 2;
% Arguments for Bilateral filter.
radius=10; sigma=[3, 0.1]; 
% Adjust the saturation of img.
img_sa = saturation_adjust(img, saturation_scalar);
% Normalize image to [0,1].
img_f = (double(img_sa)) ./ 255;
img_f = bfilter2(img_f,radius,sigma);
img_gray = rgb2gray(img_f);
edge_mask = uint8(edge(img_gray, edge_operator, edge_thresh)); 
img_blur = uint8(img_f*255);
% Highlight edges using black color.
img_res(:,:,1) = img_blur(:,:,1) - img_blur(:,:,1) .* edge_mask;
img_res(:,:,2) = img_blur(:,:,2) - img_blur(:,:,2) .* edge_mask;
img_res(:,:,3) = img_blur(:,:,3) - img_blur(:,:,3) .* edge_mask;

output=img_res;


