import cv2 as cv
import matplotlib.pyplot as plt

# 读取图像
img = cv.imread('image/pink.jpg', 0)

# 用 cv 显示
cv.imshow('pink', img)
cv.waitKey(0)

# 用 matplotlib 显示
plt.imshow(img, cmap=plt.cm.gray)
plt.show()

# 图像保存
cv.imwrite('image/pink1.png', img)




