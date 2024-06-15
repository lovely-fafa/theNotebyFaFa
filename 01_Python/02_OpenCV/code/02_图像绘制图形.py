import cv2 as cv
import matplotlib.pyplot as plt
import numpy as np

# 创建图像
img = np.zeros(shape=(512, 512, 3), dtype=np.uint8)

# 绘制横线
cv.line(img, (0, 0), (512, 512), (255, 0, 0), 5)
# 绘制圆心
cv.circle(img, (256, 256), 60, (0, 0, 255), -1)
# 绘制方形
cv.rectangle(img, (100, 100), (400, 400), (0, 255, 0), 5)
# 写字
cv.putText(img, 'fafa', (100, 150), cv.FONT_HERSHEY_SIMPLEX, 5, (255, 255, 255), 3)

plt.imshow(img[:, :, ::-1])
plt.show()
