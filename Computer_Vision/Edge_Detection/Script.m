I = imread('peppers.png');
I = rgb2gray(I);
figure(1); imshow(I); 

first_derivative_filter = edge(I, 'prewitt');
figure(2); imshow(first_derivative_filter); 

sec_derivative_filter = edge(I, 'log');
figure(3); imshow(sec_derivative_filter);

canny_algorithm = edge(I, 'canny');
figure(4); imshow(canny_algorithm);