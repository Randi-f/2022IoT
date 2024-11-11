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
axis off  %%�ر���������ʾ
%%filename��Ŵ򿪵��ļ���  pathname���·��
[filename pathname] =uigetfile({'*.jpg';'*.bmp';'*.*'},'��ͼƬ');
%%�ַ���ƴ�� ƴװ·�� ����������˵���� ��ʱ srt=F:\data\1.jpg
str=[pathname filename];
%%��ͼ��
im=imread(str);
%%��axes1�ľ�� ����axes1�Ĳ���
axes(handles.axes1);
%%��axes1����ʾ ͼ��
imshow(im);
%%path1='C:\Users\lenovo\Desktop\';
%%��axes2 �� ��ʾ���ͼ�� ���ͼ�����result�ļ�����
%%��ԭʼͼ���� F:\data\1.jpg ʱ��
%%��ʱ axes2����ʾ F:\result\1.jpg
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
input_img=imfilter(input_img,psf);%��˹��ͨ�˲���ƽ��ͼ��,�����ܻ�ʹͼ��ʧϸ��
input_img=medfilt2(input_img); %��ֵ�˲�����������
input_img = edge(input_img,'prewitt',0.04);  
[m,n]=size(input_img);
output=zeros(m,n);
output=imadjust(output);%ʹ��Եͼ�������
thresh=graythresh(output);%ȷ����ֵ����ֵ
output=bwmorph(im2bw(output,thresh),'thin',inf);%ǿ��ϸ��


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
