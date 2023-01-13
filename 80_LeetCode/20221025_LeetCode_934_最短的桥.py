from collections import deque  # 介个东西类似于列表 但是可以开头 pop()


class Solution:
    def shortestBridge(self, grid: list[list[int]]) -> int:

        n = len(grid)
        for row, i in enumerate(grid):
            for col, j in enumerate(i):

                # 搜索到了第一个岛的第一个坐标
                if j == 1:
                    # 标记为 -1 即把第一个岛全部标为 -1
                    i[col] = -1
                    # 用于记录第一个岛的所有坐标数据 以便于根据第一个岛坐标数据寻第二个岛
                    island = []
                    # 用于记录第一个岛 第一次遇到的坐标数据 仅用于辅助找到第一个的所有坐标数据
                    q = deque([(row, col)])  # 把第一个岛第一次遇到的坐标数据 以元祖的形式存在列表里面 用 deque 函数 转化为 deque 数据格式

                    # 扩展寻找其他岛
                    while q:  # 有新数据变存入 q 每次循环删掉 q 的第一个数据 当 q 没有数据便把第一个岛的坐标数据全部找到了
                        # 删第一个元素 并拿到删的值
                        row_temp, col_temp = q.popleft()
                        island.append([row_temp, col_temp])
                        # 延伸四个方向
                        search_list = [(row_temp + 1, col_temp), (row_temp - 1, col_temp),
                                       (row_temp, col_temp + 1), (row_temp, col_temp - 1)]
                        for x, y in search_list:
                            if 0 <= x < n and 0 <= y < n and grid[x][y] == 1:
                                # 标记为 -1
                                grid[x][y] = -1
                                # 记录这个点 以便于
                                q.append((x, y))

                    # 以第一个岛为基础 找第二个岛
                    step = 0
                    q = island
                    while True:
                        # 这样的话 找过的就不会再找了 感觉很难想出来
                        tem = q
                        q = []  # 存一圈的数据
                        for x, y in tem:
                            # 扩展
                            for nx, ny in (x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1):
                                if 0 <= nx < n and 0 <= ny < n:
                                    # 找到了
                                    if grid[nx][ny] == 1:
                                        return step

                                    # 把周围的第一圈 标记为找过了
                                    if grid[nx][ny] == 0:
                                        grid[nx][ny] = -1
                                        q.append((nx, ny))  # 相当于下一次遍历 只会遍历这一圈的下一圈 而不会遍历第一个岛+这一圈的下一圈
                        step += 1


s = Solution()
grid1 = [[1, 1, 1, 1, 1],
         [1, 0, 0, 0, 1],
         [1, 0, 1, 0, 1],
         [1, 0, 0, 0, 1],
         [1, 1, 1, 1, 1]]
grid = [[0, 0, 0, 0, 0, 0, 0],
        [1, 0, 0, 1, 0, 0, 0],
        [1, 1, 1, 1, 0, 0, 0],
        [0, 0, 0, 1, 0, 0, 0],
        [1, 0, 0, 0, 0, 0, 0],
        [1, 1, 0, 0, 0, 0, 0],
        [1, 0, 0, 0, 0, 0, 0]]
print(s.shortestBridge(grid))
