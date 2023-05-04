# 1 paddleocr

## 1.1 安装

安装 paddleocr

```cmd
pip install paddleocr
```

如果要使用 gpu 版的，安装 paddlepaddle-gpu

```
pip install paddlepaddle-gpu
```

【不知道是不是必须】安装shapely，但是需要先从https://www.lfd.uci.edu/~gohlke/pythonlibs/

如果报错关于 protobuf，需要

```
pip uninstall protobuf
pip install protobuf==3.20.0
```

## 1.2 简单使用

```python
from pprint import pprint

from paddleocr import PaddleOCR

img = open(r'C:\Users\lenovo\Desktop\Snipaste_2023-05-04_10-49-15.jpg', mode='rb').read()
ocr = PaddleOCR(use_angle_cls=True, lang='ch')
ocr_res = ocr.ocr(img, cls=True)
print(ocr_res)
ocr_res_list = [i[-1][0] for i in ocr_res[-1]]
pprint(ocr_res_list)
```

```python
[
    [
        [
            [[36.0, 27.0], [90.0, 27.0], [90.0, 102.0], [36.0, 102.0]], 
            ('7', 0.9953709244728088)
        ], 
        [
            [[166.0, 35.0], [208.0, 35.0], [208.0, 98.0], [166.0, 98.0]], 
            ('6', 0.9814348220825195)
        ],
    ]
]
```







