function [J grad] = nnCostFunction(nn_params, ...
                                   input_layer_size, ...
                                   hidden_layer_size, ...
                                   num_labels, ...
                                   X, y, lambda)
%NNCOSTFUNCTION Implements the neural network cost function for a two layer
%neural network which performs classification
%   [J grad] = NNCOSTFUNCTON(nn_params, hidden_layer_size, num_labels, ...
%   X, y, lambda) computes the cost and gradient of the neural network. The
%   parameters for the neural network are "unrolled" into the vector
%   nn_params and need to be converted back into the weight matrices. 
% 
%   The returned parameter grad should be a "unrolled" vector of the
%   partial derivatives of the neural network.
%

% Reshape nn_params back into the parameters Theta1 and Theta2, the weight matrices
% for our 2 layer neural network
Theta1 = reshape(nn_params(1:hidden_layer_size * (input_layer_size + 1)), ...
                 hidden_layer_size, (input_layer_size + 1));

Theta2 = reshape(nn_params((1 + (hidden_layer_size * (input_layer_size + 1))):end), ...
                 num_labels, (hidden_layer_size + 1));

% Setup some useful variables
m = size(X, 1);
         
% You need to return the following variables correctly 
J = 0;
Theta1_grad = zeros(size(Theta1));
Theta2_grad = zeros(size(Theta2));

% ====================== YOUR CODE HERE ======================
% Instructions: You should complete the code by working through the
%               following parts.
%
% Part 1: Feedforward the neural network and return the cost in the
%         variable J. After implementing Part 1, you can verify that your
%         cost function computation is correct by verifying the cost
%         computed in ex4.m
%
% Part 2: Implement the backpropagation algorithm to compute the gradients
%         Theta1_grad and Theta2_grad. You should return the partial derivatives of
%         the cost function with respect to Theta1 and Theta2 in Theta1_grad and
%         Theta2_grad, respectively. After implementing Part 2, you can check
%         that your implementation is correct by running checkNNGradients
%
%         Note: The vector y passed into the function is a vector of labels
%               containing values from 1..K. You need to map this vector into a 
%               binary vector of 1's and 0's to be used with the neural network
%               cost function.
%
%         Hint: We recommend implementing backpropagation using a for-loop
%               over the training examples if you are implementing it for the 
%               first time.
%
% Part 3: Implement regularization with the cost function and gradients.
%
%         Hint: You can implement this around the code for
%               backpropagation. That is, you can compute the gradients for
%               the regularization separately and then add them to Theta1_grad
%               and Theta2_grad from Part 2.
%


%take each value in y, convert it to corresponding binary form and store as a row in Y matrix
%when needed value of particular example, take the row and transpoe it to get the column vector

Y = zeros(length(y),num_labels);

for i=1:length(y)
    Y(i,y(i))=1;
endfor

% Y(n,:) will give vector for nth example as row vector

% Add ones to the X data matrix
X = [ones(m, 1) X];

disp(size(Theta1))
disp(size(X))
z2=X*Theta1'; %layer1
a2=sigmoid(z2);
disp(size(a2)) 

a2=[ones(size(a2,1),1) a2];

z3=a2*Theta2';
a3=sigmoid(z3);
disp(size(a3))

Jtemp=0;

for i=1:m
    temp1 = -Y(i,:) .* log(a3(i,:));
    temp2 = - (1-Y(i,:)) .* log(1-a3(i,:));
    temp3 = sum(sum(temp1+temp2))/m;
    Jtemp = Jtemp + temp3;

J = Jtemp;

% J < unregularized cost function, reg. it now

temp4 = Theta1(:,2:end) .* Theta1(:,2:end);
temp5 = Theta2(:,2:end) .* Theta2(:,2:end); 


temp6 = (sum(sum(temp4))+sum(sum(temp5)))*(lambda/(2*m));
J = J + temp6;

% -------------------------------------------------------------

% =========================================================================

% Unroll gradients
grad = [Theta1_grad(:) ; Theta2_grad(:)];


end
