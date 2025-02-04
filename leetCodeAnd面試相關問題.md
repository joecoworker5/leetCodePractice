
# leetcode (TODO) TODO
分類
monotolic q:
239 monotolic q 84, 85

sort:
912(Sort an Array: 難 mergesort)
topological sort
33(Sorted Array)
2115, 143, 368

Set:
1695(Maximum Erasure Value)

Bitwise:
136(Single Number)、137(Single Number II)

Tree: 
968(Binary Tree Cameras)

Other: 48(Rotate Image)、189(Rotate Array)、1886(Determine Whether Matrix Can Be Obtained By Rotation)

structure design:
208(Implement Trie)
622(design curcular queue)

難看不懂:
1626(Best Team With No Conflicts), 300(354)(Longest Increasing Subsequence), 741
23(Merge k Sorted Lists)

premium:
number Distict island類似de/serialize binary tree(BST)

graph:
261(Graph Valid Tree union ind判斷是否有rotate Inverse Ackermann Function)


# leetcode (finished)
LinkedList : 
2(Add Two Numbers)、
21(Merge Two Sorted Lists) -> 21的進階版, 148(Sort List:難 mergesort, 偷懶可以用priorityQueue(heap sort)但效能沒那麼好)
19(Remove Nth Node From End of List)
234(Palindrome Linked List:fast and slow/ reverse)
206(Reverse Linked List)、92(Reverse Linked List II)
160(Intersection of Two Linked Lists)
24(Swap Nodes in Pairs)
61(Rotate List)
328(Odd Even Linked List)

Hash: 
1(Two Sum)、13(Roman to Integer)、128(Longest Consecutive Sequence)、299(Bulls and Cows)
387(First Unique Character in a String)、454(4Sum II)、560(Subarray Sum Equals K 好題目，由brutal force來聯想解法)
567(Permutation in String: sliding window)
2131(Longest Palindrome by Concatenating Two Letter Words)


Ｓliding Window(通常用queue, monotonic Queue 來解決):
567(Permutation in String: sliding window)
438 (Find All Anagrams in a String, 這題和 567 基本一模ㄧ樣)
239 (Sliding Window Maximum 難 可以先從pq思考, 後面再自己用deque實作monotonic Queue試試看)
904 (Fruit Into Baskets: 這題等於Sliding Window for K Elements, 類似於3(Longest Substring Without Repeating Characters只是儲存資料結構不一樣), 658）
658(Find K Closest Elements)

Tree: 
33(Search in Rotated Sorted Array)、34(Find First and Last Position of Element in Sorted Array)、35(Search Insert Position)、94(Binary Tree Inorder Traversal/DFS and BFS)、98(Validate Binary Search Tree)、99(Recover Binary Search Tree)、100(Same Tree)、102(Binary Tree Level Order Traversal)、104(Maximum Depth of Binary Tree)、107(Binary Tree Level Order Traversal II)、108(Convert Sorted Array to Binary Search Tree)、101(Symmetric Tree)
112(Path Sum)、113(113. Path Sum II)、437(Path Sum III:難想two sum + recursion)
114(Flatten Binary Tree to Linked List)、116(Populating Next Right Pointers in Each Node)、199(Binary Tree Right Side View)、226(Invert Binary Tree)、429(N-ary Tree Level Order Traversal)、230(Kth Smallest Element in a BST)、501(Find Mode in Binary Search Tree)
543(Diameter of Binary Tree,有三種類似題型)、687(Longest Univalue Path)、617(Merge Two Binary Trees)、637(Average of Levels in Binary Tree)、700(Search in a Binary Search Tree)、814(Binary Tree Pruning)、1022(Sum of Root To Leaf Binary Numbers)(每次都想不到xdd)、979(Distribute Coins in Binary Tree)
105(Construct Binary Tree from Preorder and Inorder Traversal)
104(Maximum Depth of Binary Tree)->進階題 110(Balanced Binary Tree)
1011(Capacity To Ship Packages Within D Days:binary search)

dfs:
14(Longest Common Prefix),17(Letter Combinations of a Phone Number)、22(Generate Parentheses)、97(interleaving String tabulation)
39(Combination Sum:distinct)　40(Combination Sum II: non-distinct→sorted)
46（Permutations）、47（Permutations II, non-distinct→sorted,  if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;)、62(Unique Paths)、63(Unique Paths II)、78(Subsets)、79(Word Search)、118(Pascal's Triangle)、120(Triangle)、128(Longest Consecutive Sequence)、130(Surrounded Regions)、133(Clone Graph)、139(Word Break)、200(Number of Islands)207、(Course Schedule)、210(Course Schedule II)、399(Evaluate Division)(DAG topological sort)、221(Maximal Square)、240(Search a 2D Matrix II)、263(Ugly Number)、322( Coin Change)、494(Target Sum)、733(Flood Fill)、841(Keys and Rooms)、2244(Minimum Rounds to Complete All Tasks)、326(Power of Three)、394(Decode String)
2477(Minimum Fuel Cost to Report to the Capital)
1706(Where Will the Ball Fall)
947(Most Stones Removed with Same Row or Column)

bfs:
133(Clone Graph)、1162(As Far from Land as Possible)
、785(Is Graph Bipartite?) 題目蠻有趣
、886(Possible Bipartition)

dp:
rotate: 61(Rotate List)、64(Minimum Path Sum)、 70(Climbing Stairs)、118(Pascal's Triangle)
121(Best Time to Buy and Sell Stock)(紀錄目前最小值)、122( Best Time to Buy and Sell Stock II)(買,賣, 已買, 已賣四種狀態)、309(Best Time to Buy and Sell Stock with Cooldown)
124(Binary Tree Maximum Path Sum: 有三題類似)
152(Maximum Product Subarray) (紀錄arr index當下的最大值和最小值（三個值 做比較))
198(House Robber)、213(House RobberII) 跟stock一樣解法
263(Ugly Number)、283(Move Zeroes)、322( Coin Change)、518(Coin Change 2)
463(Island Perimeter)
997(Find the Town Judge)
1413(Minimum Value to Get Positive Step by Step Sum)
1560(Most Visited Sector in a Circular Track)
1905(Count Sub Islands)
238(Product of Array Except Self 難!)
42(Trapping Rain Water 難,但超經典有三種解法)

greedy:45(Jump Game II)(難想得出是A-1)、55（Jump Game）、53(Maximum Subarray)、134(Gas station)、334(Increasing Triplet Subsequence 好難想...)763(Partition Labels)、621(Task Scheduler)

Sort:
56(Merge Intervals)、57(Insert Interval)、435(Non-overlapping Intervals)、75(Sort Colors)、
、215(Kth Largest Element in an Array)、452. Minimum Number of Arrows to Burst Balloons、
88(Merge Sorted Array)
179(Largest Number)
148(Sort List:難 mergesort, 偷懶可以用priorityQueue(heap sort)但效能沒那麼好)


Queue: 
3( Longest Substring Without Repeating Characters)



Priority Q(heap):
1962(Remove Stones to Minimize the Total)
347(Top K Frequent Elements)
239 (Sliding Window Maximum 難 可以先從pq思考, 後面再自己用deque實作monotonic Queue試試看)
378(Kth Smallest Element in a Sorted Matrix, 其實最好的解法是 binary search 但太難無法理解)
451(Sort Characters By Frequency)

Deque實作monotonic Queue
239 (Sliding Window Maximum 難 可以先從pq思考, 後面再自己用deque實作monotonic Queue試試看)


Union find: 
200(Number of Islands)(有趣)
547(Number of Provinces)

Two Pointer
5(Longest Palindromic Substring),9(Longest Palindromic Substring),11(Container With Most Water)
、 15(3Sum)、647(Palindromic Substrings)
42(Trapping Rain Water 難,但超經典有三種解法)
88(Merge Sorted Array)
350(Intersection of Two Arrays II)

slow and fast: 141(Linked List Cycle)、142(Linked List Cycle II)、234(Palindrome Linked List:fast and slow/ reverse)、287(Find the Duplicate Number)

Stack: 20(Valid Parentheses)、
496(Next Greater Element I)、739(Daily Temperatures: 和496解題邏輯類似)
735(Asteroid Collision)

Array:
300(Longest Increasing Subsequence)(難:看不懂)
1054(Distant Barcodes)、1833. Maximum Ice Cream Bars
66(PlusOne)
162(Find Peak Element O(N)很簡單但要求 O(logN))
171(Excel Sheet Column Number)
289(Game of Life)
350(Intersection of Two Arrays II)
540(Single Element in a Sorted Array)、33(Search in Rotated Sorted Array)基本上看到sorted array就要想到 binary Search
Other: 169(Majority Element)


Structure design:
380(Insert Delete GetRandom O(1), Map<Integer, Integer> +List)
381(Insert Delete GetRandom O(1) - Duplicates allowed 困難!但蠻有趣的 Map<Integer, Set<Integer>> +List)
384(Shuffle an Array, shuffle random array)
146(LRU Cache: linkedHashMap)
173(Binary Search Tree Iterator)
232(Implement Queue using Stacks)
155(Min Stack)
208(Implement Trie (Prefix Tree))


Math:
1071(Greatest Common Divisor of Strings: 輾轉相除法)

Graph:
1443(Minimum Time to Collect All Apples in a Tree)


# 演算法筆記

### DP strategy
https://leetcode.com/problems/target-sum/solutions/455024/DP-IS-EASY!-5-Steps-to-Think-Through-DP-Questions./


### blind 75 leetcode
https://leetcode.com/discuss/general-discussion/460599/blind-75-leetcode-questions?fbclid=IwAR2EAMuK-OnmgRB5QB1a69GSOZHtLeQnIJUBEPFw7yCwqV8U6nrkhfw85y4

### LinkedList和Array差別:
Array:
優點: 存取為O(1)、節省記憶體空間(不需要pointer紀錄另一個node位置)
缺點: 大小固定超過大小會resize O(N)、資料新增刪除不易(需往前往後搬資料 O(N))
LinkedList:
優點: 可動態新增資料、新增刪除資料較容易(addFront O(1))
缺點: 耗費記憶體空間、新增刪除資料若非head(O(N))
addFront、pushBack、delete、clear、reverse

### Stack:
Last in first out : DFS
### Queue:
First in first out : BFS

### Priority Queue: 底層為heap

### Set: 沒有順序、不重複的集合
可以透過Array實作Set，透過collapsing減少FindSet需要的步驟趨近於O(1)

Union Find( time: O(N*aN, a代表樹的高度，find所需要走的路徑，可以透過collapsing降低樹的高度使其趨近於O(1)))

### Sort

             Quick Sort   	  Merge Sort   	  Heap Sort  	   Insertion Sort  Selection Sort  
best case	    NlogN   	    NlogN   	    NlogN   	       N  	              N2
average case   	NlogN  	        NlogN  	        NlogN  	           N2  	              N2
worst case	    N2  	        NlogN  	        NlogN  	           N2  	              N2
Insertion sort : intsert i element into i-1 sorted array
Quick Sort: pivot Sorting, partition(Partition的功能就是把數列「區分」成「小於pivot」與「大於pivot」兩半)
heap sort: 每加入一個node此node需要向上換logN次若有N個node就會是 Nlog(N)
merge sort: divide and conquer

Tree特徵:只有一個root(node皆為connected)，並且不存在cycle。

### Binary Tree: 每個node有兩個child
### dfs/stack: 
inorder/preorder/postorder traversal
getSuccessor搭配leftmost
TreeNode* BinaryTree::InorderSuccessor(TreeNode *current){
    if (current->rightchild != NULL){
        return leftmost(current->rightchild);
    }

    // 利用兩個pointer: successor與current做traversal 

    TreeNode *successor = current->parent;   
    while (successor != NULL && current == successor->rightchild) {
        current = successor;
        successor = successor->parent;
    }
    return successor;
}

void BinaryTree::Inorder_by_parent(TreeNode *root){
    TreeNode *current = new TreeNode;
    current = leftmost(root);

    while(current){
        std::cout << current->str << " ";
        current = InorderSuccessor(current);
    }
}


### bfs/queue: level order traversal

### Binary Search Tree: Binary Tree再增加「鍵值(Key)大小規則」(i.e. Key(L)<Key(Current)<Key(R)) : inorder traversal即可得到小到大的排序
### Red Black Tree(RBT，紅黑樹: BST為基礎，在每個node上添加顏色(紅與黑)用以平衡樹的height，以減短搜尋時間LogN，RBT可以被視為如同Complete Binary Tree的BST
RBT擁有最長path(路徑)不會超過最短path的兩倍的特性。

### hashTable:
使時間複雜度為O(1)
解決用Array index儲存資料太浪費記憶體空間的問題

hashfunction(key) = hashtable key
透過hash function將原本的key轉換成對應到符合Table大小m的範圍內 ( h:U→{0,1,...,m−1},where|U|≫m)

hash function設計不易有以下要求且有以下幾種類型
demands: Uniform distributed(防止collision)
1.Division Method：m有限制，但是比較快。
2.Multiplication Method：m沒有限制，但是比較慢。
1. Universal Hashing以及Perfect Hashing→least collision

但轉換出的hashtable key可能會發生重複的問題(collision)，解決方法有二：
1.Chaining：使用Linked list把「Hashing到同一個slot」的資料串起來。
search: O(1+a(loading factor=n/m))
insert: O(1)
delete: o{1+a)

2.Open Addressing：使用Probing Method來尋找Table中「空的slot」存放資料。
有linear probing, quadratic probing, double hashing等方式
			Open Addressing	    Chaining
Unsuccessful Search   	1/1−α		    1+α
Successful Search	1/α(ln 1/(1−α))     1+α

根據α(loading factor)決定哪個效能比較好，當α->1時Open Addressing time O(無限大)此時用chaining會比較好

### Graph:
vertex：稱每一個「資料節點」為vertex(或是node)，並定義所有的vertex所形成之集合(Set)為V或V(G)；
edge：稱每一個「線段(箭號)」為edge(實際上是用一對vertex表示edge，例如(Vi,Vj)即為連結Vi與Vj的edge)，並定義所有的edge所形成之集合(Set)為E或E(G)；
Graph定義為V與E所形成的集合，表示成G(V,E)。
表示Graph有幾種方法1. matrix, 2.Adjacency list
BFS/DFS/topological sort

### DB index
create index means create B-tree / B+ tree, that combine the relevent data to construct tree structure, that leads to faster query

## Advantages:
1. B-tree
    - balanced binary tree, compared to Binary Search Tree is more flatten
    - each node can store more keys thats shorten tree height leads to faster query time complexity
2. B+ tree
    - leaf node can traverse to another leaf node horizontally, that shorten search path

## DisAdvantage
1. each index would create B-tree, that consume DB resource
2. delete insert data would also need time to modify B-tree structure


### Java HashSet HashMap ArrayList
ArrayList: 底層為 array, default size = 10
HashSet: 底層為HashMap
HashMap: 底層為 Entry[], default size = 16, loading factor = 0.75, 當發生key hash完的hashCode相同發生collision時, 會看 Entry chain上的Entry的key值是否相同, 如果相同就update, 不相同則建一筆新的 Entry chain在後面
ConcurrentHashMap: thread-safe, 他底層基本概念為分成好多個segment, 每個segment可視為hashMap, 不同thread操作不同segment, 所以為thread safe


# 網路相關問題
https://blog.csdn.net/weixin_43122090/article/details/105462015 幾乎全包了

### 網路根據 OSI模型分七層／根據TCP/IP模型分四層, 其中 TCP/UDP是傳輸層, 而HTTP, HTTPS, SMTP, FTP則是基於傳輸層為基礎的應用層

### Socket/HTTP
WebSocket: stateful, 長連線且雙向, client 和 server 可以主動互相傳輸數據, 主要用在直播, 股票軟體
HTTP: stateless, 短連接request/response完即結束連線, client主動打給server, server被動回應response, 用於網站, 電商

https://medium.com/enjoy-life-enjoy-coding/javascript-websocket-%E8%AE%93%E5%89%8D%E5%BE%8C%E7%AB%AF%E6%B2%92%E6%9C%89%E8%B7%9D%E9%9B%A2-34536c333e1b


### TCP(三次握手/四次揮手)/UDP
TCP如同打電話,確保資料有被傳輸到對方手中
UDP如同廣播, 不管資料是否有傳輸到對方手中, 一直傳輸就對了


https://nordvpn.com/zh-tw/blog/tcp-udp-bijiao/
https://blog.csdn.net/weixin_43122090/article/details/105462015


### 3次握手4次揮手
#### 3次握手情境
A: 喂, 聽得到嗎?
Ｂ: 聽得到喔, 你聽得到嗎?
A: 聽得到喔
Q: 建立连接可以两次握手吗？为什么?
Ans: 不行，两次握手无法保证Client正确接收第二次握手的报文（Server无法确认Client是否收到），也无法保证Client和Server之间成功互换初始序列号。

#### 4次揮手情境
A: 我要離職
HR: 好的
-----HR 辦理員工離職手續,或是處理員工先前未完成的資料-------
HR: 資料都處理完囉, 你可以離職囉?
A: 好的, 我離職囉

Q1: 为什么不能把服务器发送的ACK和FIN合并起来，变成三次挥手（CLOSE_WAIT状态意义是什么）？
ANS:因为服务器收到客户端断开连接的请求时，可能还有一些数据没有发完，这时先回复ACK，表示接收到了断开连接的请求。等到数据发完之后再发FIN，断开服务器到客户端的数据传送。

Q2: 客户端TIME_WAIT状态的意义是什么？
ANS: 第四次挥手时，客户端发送给服务器的ACK有可能丢失，TIME_WAIT状态就是用来重发可能丢失的ACK报文。如果Server没有收到ACK，就会重发FIN，如果Client在2*MSL的时间内收到了FIN，就会重新发送ACK并再次等待2MSL，防止Server没有收到ACK而不断重发FIN。 MSL(Maximum Segment Lifetime)，指一个片段在网络中最大的存活时间，2MSL就是一个发送和一个回复所需的最大时间。如果直到2MSL，Client都没有再次收到FIN，那么Client推断ACK已经被成功接收，则结束TCP连接。

### RabbitMQ/KafKaServer/ActiveMQ
這種MQ的架構通常有五種模式(direct/worker/publisher(subscribe)/routing/topics)
1. RabbitMQ(most freqently used)
https://kucw.github.io/blog/2020/11/rabbitmq/
https://netfilx.github.io/spring-boot/8.springboot-rabbitmq/springboot-rabbitmq

-Worker模式
在現在 microservice 很流行的情形下，如果有大量的 asynchronous job 要執行，通常就不會使用 Java 裡的 ThreadPool，而是會改使用這種 Worker 模式，讓許多台 node 可以一起幫忙做
2. kafkaServer
主要用於高流量, 因為其良好的 availability, scalability



### Distributed system
Q: 面對高流量系統架構該如何設計?
https://ithelp.ithome.com.tw/m/articles/10271214




# SSP Info
### System Analysis
本家系統 
每天: 3000w
平日: 350 QPS
尖峰: 1400 QPS
優化方式
1. 加開8機器: 350/8 = 43 QPS(TPS)(request concurrency/responsive time)
2. 內部程式優化
    - cache
    - less time complexity, less recurrsion, less nested for loop
    - SQL partition table, less join and group by
    - NoSql prevent read write IO blocking

momo platform: 
11/11當周: 1450 QPS ~ 2050 QPS
平日: 350 QPS
為了應付雙11預估 25000 QPS 的尖峰, 系統不會 crash 掉, 且要維持在 200ms 以內回 response
1. 程式面優化
   - 從序列發改成併發
   - single -> bulk 更改 API 架構
   - 減少不必要的log, asynchrounous  logging 及增大 log thread pool
   - 設置 timeout 100ms, 當 API 沒有回應就當作沒有廣告, release thread
   - nginx/SpringBoot 設定 log rotate 避免 log 塞爆磁碟
2. 系統面優化
   - AWS 新增 ASG, 根據單台 EC2 QPS 決定 Scale out/in
   - 怕瞬間流量導致系統 crash, nginx 限制 ratelimit 為 300QPS
3. 報表面優化: 
   - spark在幾台, 幾core, 多少numPartitions, 可以在 8hr 跑完一整天 ~1.5T log的時間(spark core == numPartitions 最快)
   - spark 40 台 320cores, 8 小時內跑的完
4. 用 k6 執行壓測確保系統運作正常
      - 撰寫 k6 腳本
      - 將 k6 用 docker build 成可執行的檔案
      - 搭配 AWS ASG 用分散式壓測系統來達到 25000 QPS 壓測需求
5. 監控系統是否正常
   - spring 使用 micrometer 來記錄 metrics, 透過串接 prometheus server 以及 grafana 來監控系統各項狀態
   - 使用 htop 等指令監控 CPU, load 等指標
    


### 系統升級
- java 8 -> 17
- spring boot 1.5 -> 2.7.4
- spring 4 -> 5




### Aggregation optimization
1. Split date range from one month to 1 day multiply 30, to reduce heap memory maximun usage
2. PostGreSQL table partition to reduce the reading/write time, that divide table into multiple subtable according to each month
3. Replace JPA with native SQL to persue faster SQL excecution time
4. Loading cache in advance to avoid repeat Query
5. Group by before join to avoid group by too much column in one time

### Enhance Report Query
1. table partitioned by month
2. Group by before join to avoid group by too much column in one time
3. create column index to enhance DB query speed



###
1. In charge of the Ad Supply Side Platform in a Real-Time Bidding (RTB) system, implementing multi- threading and concurrency  
   techniques for issuing Ad requests to the Ad Exchange System.
2. Achieved a significant system improvement, enhancing throughput from 50 to 260 QPS within 200ms bid Response time limit       
   through sequential-to-concurrent transition, API interface reconstruction, and asynchronous logging to mitigate I/O blocking.
3. Optimized data aggregation for reporting, storing eight times more data in PostgreSQL than the previous version. The data 
   aggregation process now completes in 25% of the previous time, and queries takes in half the time.
4. Managed the data pipeline, sending Ad event logs to Azure blob, transforming raw logs to aggregation logs using Spark, and
   storing the data in PostgreSQL.
5. Implemented Cassandra and Cache to reduce latency during high traffic periods. 
6. Employed integration tests, unit tests, and K6 pressure tests to enhance code quality and validate business logic.
7. Utilized Jenkins, Gradle for CI/CD, and Git with Sourcetree for version control.
8. Monitored server systems using Prometheus and Grafana, while VisualVM was employed to observe heap memory usage.
9. Conducted troubleshooting of abnormal data by analyzing trailing logs to identify and address root causes.
10. Collaborated with users to align with business requirements, breaking down business logic into story 
    tasks during Scrum sessions.


# liquidbase, POI, JXLS, NGINX, Gradle, docker, AWS(S3, EC2, ELB), GCP(GA4, BidQuery)












