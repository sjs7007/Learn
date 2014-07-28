function g = sigmoid(z)
%SIGMOID Compute sigmoid functoon
%   J = SIGMOID(z) computes the sigmoid of z.

% You need to return the following variables correctly 
g = zeros(size(z));

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the sigmoid of each value of z (z can be a matrix,
%               vector or scalar).

% g = 1/(1+exp(-z))

%if size g ==0 implies, only single number is input else matrix is input
if(size(g)==0)
	g = 1/(1+exp(-z))
else
%use . to perform operation on each and every element of the matrix
	g = 1 ./ (1+exp(-z))
endif 

% =============================================================

end
