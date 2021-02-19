//#include <iostream>
//#include <string>
//#include <sstream>
//#include <vector>
//#include <map>
//
//using namespace std;
//
//int* mem;
//int w;
//
//// map<pair<int, int>, int> mem;
//vector<pair<int, int>> choices;
//
//int wasted(int slabx, int slaby) {
//
//    int idx = slabx + w * slaby;
//    if (mem[idx] != -1) {
//        cout << mem[idx] << " " << idx;
//        return mem[idx];
//    }
//
//    int m = slabx * slaby;
//
//    for (pair<int, int> c : choices) {
//        if (c.first <= slabx && c.second <= slaby) {
//            int c1 = wasted(slabx - c.first, slaby) + wasted(c.first, slaby - c.second);
//            int c2 = wasted(slabx, slaby - c.second) + wasted(slabx - c.first, c.second);
//            m = min(m, c1);
//            if (m == 0) {
//                return 0;
//            }
//            m = min(m, c2);
//            if (m == 0) {
//                return 0;
//            }
//        }
//    }
//
//    mem[idx] = m;
//    return m;
//}
//
//
//int main(int argc, char* argv[])
//{
//
//    int slabx;
//    int slaby;
//    int n;
//
//    cin >> slabx;
//    cin >> slaby;
//    cin >> n;
//
//    w = slabx;
//    mem = new int[slabx * slaby];
//    for (int i = 0; i < slabx * slaby; i++)
//        mem[i] = -1;
//
//    for (int i = 0; i < n; i++) {
//        int x, y;
//        cin >> x;
//        cin >> y;
//        choices.push_back(make_pair(x, y));
//    }
//
//    int min = wasted(slabx, slaby);
//
//    cout << min << endl;
//}


#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <map>

using namespace std;

map<pair<int, int>, int> mem;
vector<pair<int, int>> choices;

int wasted(int slabx, int slaby) {
    pair<int, int> key = pair<int, int>(slabx, slaby);
    if (mem.find(key) != mem.end()) {
        return mem[key];
    }

    int m = slabx * slaby;

    for (pair<int, int> c : choices) {
        if (c.first <= slabx && c.second <= slaby) {
            int c1 = wasted(slabx - c.first, slaby) + wasted(c.first, slaby - c.second);
            int c2 = wasted(slabx, slaby - c.second) + wasted(slabx - c.first, c.second);
            m = min(m, c1);
            if (m == 0) {
                return 0;
            }
            m = min(m, c2);
            if (m == 0) {
                return 0;
            }
        }
    }

    mem[key] = m;
    return m;
}


int main(int argc, char* argv[])
{

    int slabx;
    int slaby;
    int n;

    cin >> slabx;
    cin >> slaby;
    cin >> n;

    for (int i = 0; i < n; i++) {
        int x, y;
        cin >> x;
        cin >> y;
        choices.push_back(make_pair(x, y));
    }

    int min = wasted(slabx, slaby);

    cout << min << endl;
}