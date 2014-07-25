function J = computeCost(X, y, theta)
%COMPUTECOST Compute cost for linear regression
%   J = COMPUTECOST(X, y, theta) computes the cost of using theta as the
%   parameter for linear regression to fit the data points in X and y

% Initialize some useful values
m = length(y); % number of training examples

% You need to return the following variables correctly 
J = 0;

% ====================== YOUR CODE HERE ======================
% Instructions: Compute the cost of a particular choice of theta
%               You should set J to the cost.

% theta is column vector(2*1), first convert it to row vector as theta'(1*2)
% then X is a 97 * 2 matrix consisting of 97 training example values for x0, always =1 and x1
% take X' to get (2*97) matrix
% to get htheta(x)=multiply theta' and X' to get 1*97 matrix
temp1 = theta' * X'; 

%convert row vector temp1 to column vector 97*1
temp1=temp1';

%do temp1 - temp2
temp2 = temp1 - y;

%difference square
temp2 = temp2 .^ 2;

%return sum of each column
temp3=sum(temp2)/(2*m);

%return sum of row vector
temp4 = sum(temp3);

%assign temp4 to J
J=temp4
% =========================================================================

end
