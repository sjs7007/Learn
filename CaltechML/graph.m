axis([-50,50,-50,50],"manual")

X=zeros(4,3);
W=[0,1,-1];
X(:,1)=1; %make all artificial para = 1
X(:,2:3)=[[1,3];[2,4];[3,6];[5,7]];
x=-10:1:10;
sepLine = -(W(1)+W(2)*x)/W(3);
plot(sepLine,x,X(:,2),X(:,3),"*");

input("Press any key to continue.....");

W=W+0.1;
sepLine = -(W(1)+W(2)*x)/W(3);
plot(sepLine,x,X(:,2),X(:,3),"*");


