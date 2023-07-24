from typing import List


class Solution:

    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        max_dis = -1
        go = (0, 1)
        location = [0, 0]
        obstacles = set(map(tuple, obstacles))
        for command in commands:
            print(f'command={command}')
            if command == -2:  # [0, 1] 向左 [-1, 0] 向左 [0, -1] 向左 [1, 0] 向左 [0, 1]
                go = {(0, 1): (-1, 0), (-1, 0): (0, -1), (0, -1): (1, 0), (1, 0): (0, 1)}[go]
                print(f'向左 | go={go}')
                continue
            elif command == -1:  # [0, 1] 向右 [1, 0] 向右 [0, -1] 向右 [-1, 0] 向右 [0, 1]
                go = {(0, 1): (1, 0), (1, 0): (0, -1), (0, -1): (-1, 0), (-1, 0): (0, 1)}[go]
                print(f'向右 | go={go}')
                continue
            for step in range(command):
                location_tem = [location[0] + go[0] * 1, location[1] + go[1] * 1]
                if set(location_tem) in obstacles:
                    print(f'在：{location_tem}')
                    break
                location = location_tem
                distance = location[0] ** 2 + location[1] ** 2
                print(f'location={location} dis={distance}')
                if distance > max_dis:
                    max_dis = distance
        return max_dis


print(Solution().robotSim(commands=[4, -1, 4, -2, 4], obstacles=[[2, 4]]))
# print(Solution().robotSim(commands=[4, -1, 3], obstacles=[]))
