function varargout = untitled5(varargin)
% UNTITLED5 MATLAB code for untitled5.fig
%      UNTITLED5, by itself, creates a new UNTITLED5 or raises the existing
%      singleton*.
%
%      H = UNTITLED5 returns the handle to a new UNTITLED5 or the handle to
%      the existing singleton*.
%
%      UNTITLED5('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in UNTITLED5.M with the given input arguments.
%
%      UNTITLED5('Property','Value',...) creates a new UNTITLED5 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before untitled5_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to untitled5_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help untitled5

% Last Modified by GUIDE v2.5 01-Jul-2022 09:36:32

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @untitled5_OpeningFcn, ...
                   'gui_OutputFcn',  @untitled5_OutputFcn, ...
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


% --- Executes just before untitled5 is made visible.
function untitled5_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to untitled5 (see VARARGIN)

% Choose default command line output for untitled5
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes untitled5 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = untitled5_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
axis off  %%关闭坐标轴显示
%%filename存放打开的文件名  pathname存放路径
[filename pathname] =uigetfile({'*.jpg';'*.bmp';'*.*'},'打开图片');
%%字符串拼接 拼装路径 以上面例子说所述 此时 srt=F:\data\1.jpg
str=[pathname filename];
%%打开图像
im=imread(str);
%%打开axes1的句柄 进行axes1的操作
axes(handles.axes1);
%%在axes1中显示 图像
imshow(im);
%%path1='C:\Users\lenovo\Desktop\';
%%在axes2 中 显示结果图像 结果图像存在result文件夹中
%%当原始图像是 F:\data\1.jpg 时候
%%此时 axes2将显示 F:\result\1.jpg
str1=[path1 filename]
im1=imread(str1);
f=my_edge(im1,'prewitt');
axes(handles.axes2);
imshow(f);

% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% --- Executes during object creation, after setting all properties.

function output = my_edge(input_img,method)
if size(input_img,3)==3
    input_img=rgb2gray(input_img);
end
input_img=im2double(input_img);
psf=fspecial('gaussian',[5,5],1);
input_img=imfilter(input_img,psf);%高斯低通滤波，平滑图像,但可能会使图像丢失细节
input_img=medfilt2(input_img); %中值滤波消除孤立点
input_img = edge(input_img,'prewitt',0.04);  
[m,n]=size(input_img);
output=zeros(m,n);
output=imadjust(output);%使边缘图像更明显
thresh=graythresh(output);%确定二值化阈值
output=bwmorph(im2bw(output,thresh),'thin',inf);%强化细节


% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in pushbutton3.
function pushbutton3_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
