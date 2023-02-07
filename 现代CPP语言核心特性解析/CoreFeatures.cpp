
#include <iostream>
#include <Windows.h>
#include <memory>
using namespace std;

//  一
#include <limits>
namespace NewDataType
{

    /*    新增Longlong类型    */
    void test1()
    {
        //基本使用
        long long a = 65535 << 16;              //无LL后缀默认int，左移后超范围了
        unsigned long long b = 65535LL << 16;

        // 宏/模板 查看long long类型的常量值
        cout << "LLONG_MAX=" << LLONG_MAX << endl;
        cout << "std::numeric_limits<long long>=" << std::numeric_limits<long long>::max << endl;
        cout << "std::numeric_limits<unsigned long long>=" << std::numeric_limits<unsigned long long>::max << endl;
    }
    
    /*  新增字符 char16_t 和 char32_t    */
    void test2()
    {
        char utf8c = u8'a';
        char16_t utf16c = u'域';
        char32_t utf32c = U'恒';
        // C++20还有char8_t
    }
}

//  二
namespace InlineAndNested
{
    /*  inline命名空间  */
    inline namespace test
    {
        //  inline后相当于直接暴露，所以inline里的东西可以直接使用
    }

    namespace A::B::inline C
    {
        //  嵌套声明命名空间
    }
}

//  三
namespace Auto_usage
{
    void f() {}
    //  auto推导规则
    void test1()
    {
        //  auto会忽略cv限定符
        const int x1 = 5;
        auto x2 = x1; //j为int
        //  引用属性会被忽略
        int x3 = 4;
        int& x4 = x3;
        auto x5 = x4;
        //  万能引用会将 左值推导为引用
        int x6 = 7;
        auto&& x7 = x6;
        auto&& x8 = 7;
        //  推导数组或函数，会退化为指针
        auto pf1 = f;
        auto pf2 = &f;
        //  初始化列表的推导
        auto xx1 = { 1,2 }; // 用=赋值，都是std::initializer_list<int>
        auto xx2{ 4 };      // 单元素普通推导，不能多元素
    }

    //  lambda中auto的应用
    void test2()
    {
        auto foo = [](int& i)->auto& {return i; };  //lambda返回引用的唯一方法
    }

    //  返回值推导
    template<typename T1,typename T2>
    auto test3(T1 a1,T2 a2)
    {
        //  确保所有的返回值都是同一类型
        return a1 + a2;
    }
    auto test4(int a1, int a2)->int
    {
        return a1 + a2;
    }
    template<typename T1, typename T2>
    auto test5(T1 a1, T2 a2)->decltype(a1 + a2)
    {
        return a1 + a2;
    }
    template<typename T>
    auto test6(T& t)->decltype(t)
    //decltype(auto) test7(T& t)
    {
        //如果不后置decltype推导，不能返回引用
        //auto会被推导为值类型
        return t;
    }

    
}

// 四
namespace Decltype_usage
{
    struct A
    {
        int a = 7;
    };

    //  typeid
    void test1(auto i)
    {
        cout << typeid(i).name();
    }

    //  decltype的类型推导
    void test2()
    {
        //  表达式转为引用
        const A a;
        int i;
        decltype(a.a);   //  int
        decltype((a.a)); //  const int&
        decltype(i++);   //  int
        decltype(++i);   //  int &
        //  cv限定符会保留
        const int x1 = 4;
        decltype(x1);    //  const int
        decltype(a.a);   //  上级的cv符不会保留，但如果是推导式就会
    }
}

//五 见 三

// 六
namespace Rvalue
{
    class X
    {
    public:
        X() = default;
        X(const X& x) { cout << "copy Ctor" << endl; }
        X& operator=(const X& x)
        {
            cout << "operator= for copy" << endl;
            return *this;
        }
        X(X&& x) noexcept { cout << "move Ctor" << endl; }
        X& operator=(X&& x) noexcept
        {
            cout << "operator= for move" << endl;
            return *this;
        }
    };
    X foo(X x)
    {
        return x;
    }

    void show(auto T)
    {
        cout << typeid(T).name() << endl;
    }
    template<typename T>
    void _forward(T&& x)
    {
        show(std::forward<T>(x));
    }

    void test1()
    {
        X x = foo(X{});
    }
    
    void test2()
    {
        _forward("常量");
        double k = 4.0;
        double& kk = k;
        _forward(kk);
    }
}

//  七
namespace Lambda
{
    //基本语法： [ captures ] ( params ) specifiers exception -> ret { body }
    void test1()
    {
		auto f = []<typename T>(const T & t) {};
        auto ff = [](int a1, int a2) {return a1 > a2; };
    }
}

// 八
namespace ClassMemberInit
{
    class T
    {
        int a = 777;
        //不能auto ,不能用()初始化
    };
}

// 九
namespace Initializer_List
{
    void test1()
    {
        //什么时候支持隐式转换？1.能否转过去；2.能否转过去后转回来
        int x = 999;
        int y = 99;
        const int z = 99;
        //char c1{ x };   //编译失败
        //char c2{ y };   //编译失败
        char c3{ z };
    }
}

// 十
namespace Default_Delete_BasicClassFunction
{
    class NoCopyClass
    {
        int a = 5;
    public:
        explicit NoCopyClass() = default;
        NoCopyClass(const NoCopyClass&) = delete;
        NoCopyClass& operator=(const NoCopyClass&) = delete;
    };

    void test1()
    {
        NoCopyClass c;
        //NoCopyClass cc = c; //不能copy构造，因为删除了
    }
}

// 十二 、 十三
class EntruetCtor_AND_InheritCtor
{
    class Base
    {
        int a;
        double b;
        void Initialization() {}
    public:
        Base():Base(0){}
        Base(int _a):Base(_a,0.){}
        Base(double _b):Base(0,_b){}
        Base(int _a, int _b) :a(_a), b(_b) { Initialization(); }
        Base(const Base& x):Base(x.a,x.b){}  //委托Copy构造
    };

    class Derived : public Base
    {
    public:
        using Base::Base;   //以后可以隐式进行Derived(int)等
        Derived(double) { cout << "会覆盖Base::(double)"; }
    };
};

// 十四
namespace Enum
{
    enum C1{C1A,C1B,C1C};
    enum class C2 : int {C2A,C2B,C2C};
    void test1()
    {
        int i1 = C1A;
        int i2 = static_cast<int>(C2::C2B);
        cout << i1 << "," << i2;
    }
}

// 十六
namespace Override_AND_Final
{
    class Base
    {
    public:
        virtual void foo() { cout << "Base::foo" << endl; }
        virtual void Ffinal() final { cout << "Final function" << endl; }   //Final 虚函数，派生类不能重写，只能使用
    };

    class Derived : public Base
    {
    public:
        virtual void foo() override { cout << "Derived::foo" << endl; }

    };

    class Fclass final
    {
        //此类不能被继承
    };

    void test()
    {
        Derived d;
        d.Ffinal();
    }

}

//  十七
#include <vector>
namespace for_base_on_range
{
    class T
    {
        vector<int> v1;
    public:
        vector<int>& items()
        {
            return v1;
        }
    };

    T foo()
    {
        T t;
        return t;
    }

    class IntIter
    {
        int* p;
    public:
        IntIter(int* a) :p(a) {}
        int operator*() const
        {
            return *p;
        }
        bool operator!=(const IntIter& iter) const
        {
            return p != iter.p;
        }
        const IntIter& operator++()
        {
            p++;
            return *this;
        }
    };

    template<unsigned int FVsize>
    class FixVector
    {
        int a[FVsize]{ 0 };
    public:
        FixVector(std::initializer_list<int> init_list)
        {
            int* p = a;
            for (auto& i : init_list)
            {
                *p = i;
                p++;
            }
        }
        IntIter begin()
        {
            return IntIter(a);
        }
        IntIter end()
        {
            return IntIter(a + FVsize);
        }
    };



    //  基本用法
    void test1()
    {
        vector<int> v{ 1,2,3,4,5 };
        for (const auto& e : v)
            cout << e << "\t";
        cout << endl;
    }

    //  注意临时范围表达式结果的生命周期
    void test2()
    {
        //for (auto& e : foo().items()) {}    UB
        
        for ( T things = foo();auto & e : things.items()) {}
    }
    
    //  自定义的类 使用 基于范围for
    void test3()
    {
        FixVector<10> fv{ 1,3,4,5,6 };
        for (auto e : fv)
            cout << e << "\t";
        cout << endl;
    }
}

// 十八
#include <condition_variable>
#include <mutex>
#include <chrono>
#include <ctime>
namespace init_for_judge
{
    using namespace std::chrono_literals;
    bool foo()
    {
        srand((unsigned)time(0));
        int i = rand();
        if (i % 2 == 0)
            return true;
        else
            return false;
    }

    //在if中初始化
    void test1()
    {
        if (bool b = foo(); b)
        {
            cout << b << endl;
        }
        else
        {
            cout << b << endl;
        }
    }

    //if初始化中加锁
    void test2()
    {
        std::mutex Mutex;
        bool shared_flag = true;
        if (std::lock_guard<std::mutex> lg(Mutex); shared_flag)
        {
            shared_flag = false;
        }
    }

    //在swithc中使用
    void test3()
    {
        std::condition_variable cv;
        std::mutex cv_m;
        switch (std::unique_lock<std::mutex> lk(cv_m); cv.wait_for(lk, 100ms))
        {
        case std::cv_status::timeout:cout << "timeout" << endl; break;
        case std::cv_status::no_timeout:cout<< "no timeout" << endl; break;
        }
    }
}

// 十九
namespace Static_Assert
{
    void test1()
    {
        //static_assert(1 > 2);
        //static_assert(1 > 2,"1不能大于2");
    }
}

// 二十
#include <map>
namespace Tuple_Bind
{
    struct BindTest
    {
        int a = 6;
        string b = "abcdef";
    };
    // 结构化绑定
    void test1()
    {
        //基本使用
        auto [x, y] = make_tuple(123, "abc");
        cout << "x:" << typeid(x).name() << " ,y:" << typeid(y).name() << endl;

        //结构化绑定 遍历vector
        vector<BindTest> v{ {11,"aa"},{22,"bb"},{33,"cc"},{44,"dd"} };
        cout << "tuple range for vector" << endl;
        for (auto [first, second] : v)  //会额外复制
        {
            cout << first << "," << second << endl;
        }

        //结构化绑定 遍历map
        map<int, string> m{ {44,"kk"},{66,"gg"},{55,"pp"},{77,"oo"} };
        cout << "tuple range for map" << endl;
        for (const auto& [first, second] : m)
        {
            cout << first << "," << second << endl;
        }
    }
}

// 二十一
namespace Noexception
{
    void foo() noexcept {}
    void f() {}

    template<typename T>    // 模板中使用noexcept
    T copy(const T& o) noexcept(noexcept(T(o))) {}

    //基本用法
    void test1() noexcept       // 定义作用
    {
        // 运算判断作用
        cout << noexcept(foo()) << endl;
        cout << noexcept(f()) << endl;
    }


    // 实现模板重载的noexcept swap
    struct X1 {
        X1() {}
        X1(X1&&) noexcept {}
        X1(const X1&) {}
        X1 operator=(X1&&) noexcept { return *this; }
        X1 operator=(const X1&) { return *this; }
    };
    struct X2 {
        X2() {}
        X2(X2&&) {}
        X2(const X2&) {}
        X2 operator=(X2&&){ return *this; }
        X2 operator=(const X2&) { return *this; }
    };
    template<typename T>
    void swap_impl(T& a, T& b, std::integral_constant<bool, true>) noexcept
    {
        cout << "for move swap" << endl;
        T tmp(std::move(a));
        a = std::move(b);
        b = std::move(tmp);
    }
    template<typename T>
    void swap_impl(T& a, T& b, std::integral_constant<bool, false>) noexcept
    {
        cout << "for copy swap" << endl;
        T tmp(a);
        a = b;
        b = tmp;
    }
    template<typename T>
    void swap(T& a, T& b)
        noexcept(noexcept(swap_impl(a, b, std::integral_constant<bool, noexcept(T(std::move(a)))
            && noexcept(a.operator=(std::move(b)))>())))
            {
                swap_impl(a,b,std::integral_constant<bool,noexcept(T(std::move(a)))
                    && noexcept(a.operator=(std::move(b)))>());
	        }
    void test2()
    {
        X1 x11, x12;
        swap(x11, x12); //for move swap
        X2 x21, x22;
        swap(x21, x22); //for copy swap
    }

    void (*fp1)() noexcept = nullptr;
    void foo1(){}
    // 异常类型
    void test3()
    {
        //fp1 = &foo1;      不能将noexcept类型指向普通类型，反之可以
    }

}

// 二十二
namespace Using_with_Typedef
{
    // 基本使用
    void test1()
    {
        typedef void(*pf1)(int, int);
        using pf2 = void (*)(int, int);
    }

    template<typename T>
    using int_map1 = std::map<int, T>;

    template<typename T>
    struct int_map2
    {
        typedef std::map<int, T> type;
    };
    void test2()
    {
        int_map1<std::string> im1;
        int_map2<std::string>::type im2;
        //  如果是别的类中使用int_map2，需要先typename先表明
    }

}

// 二十三
namespace Nullptr
{
    void test1()
    {
        char* ch1 = nullptr;    // nullptr 是一个 std::nullptr_t 类型的一个 纯右值、CPP的关键字
        std::nullptr_t nulla;   // 此时 nulla 与 nullptr 有相同的作用 ，但 nulla是一个左值
    }

    template<typename T>
    void foo() {}

    template<>
    void foo<std::nullptr_t>()  {}
    
    // 可以弄一个nullptr特化
}

// 二十四
namespace Three_way_Comparable
{
    struct Base
    {
        int a;
        long b;
        auto operator<=>(const Base&) const = default;
    };
    struct Derived : public Base
    {
        short c;
        auto operator<=>(const Derived&) const = default;
        //如果<=>比较的两个对象不能交换顺序，应该把auto改成std::weak_ordering
        //不然默认会返回std::strong_ordering
        //对于派生类，auto的推导约束性不能高于基类
    };
    void test1()
    {
        cout << typeid(decltype(7 <=> 11)).name() << endl;                  //std::strong_ordering
        cout << typeid(decltype(Derived() <=> Derived())).name() << endl;   //std::strong_ordering
        cout << typeid(decltype(7.11 <=> 11.22)).name() << endl;            //std::partial_ordering::unordered
    }

    void test2()
    {
        //如果类实现了operator<=>,会自动生成 < , > , <= , >=
        //如果类实现了operator==,会自动生成 !=
    }
}

// 二十五
#include <thread>
#include <mutex>
namespace Thread_Local
{
    mutex _Mutex;
    struct X
    {
        int i = 0;
        string str;
    public:
        X(const char* c) :str(c) 
        { 
            lock_guard<std::mutex> lg(_Mutex);
            cout << this_thread::get_id() << ":";
            cout << "ctor " << str << endl; 
        }
        ~X() 
        { 
            lock_guard<std::mutex> lg(_Mutex);
            cout << this_thread::get_id() << ":";
            cout << "dtor " << str << ",id=" << i << endl;
        }
        void inc() {
            lock_guard<std::mutex> lg(_Mutex);
            cout << this_thread::get_id() << ":";
            cout << str << ",id=" << ++i << endl;
        }
    };
    void foo(const char* m)
    {
        cout << "foo:";
        thread_local X tv(m);
        //每个线程局部对象在每个线程只能初始化一次
        tv.inc();
    }
    void bar(const char* m)
    {
        cout << "bar:";
        thread_local X tv(m);
        tv.inc();
    }
    void thread1()
    {
        cout << endl;
        foo("thread1");
        foo("thread1");
        foo("thread1");
    }
    void thread2()
    {
        Sleep(50);
        cout << endl;
        foo("thread2");
        foo("thread2");
        bar("thread2");
    }
    void thread3()
    {
        Sleep(100);
        cout << endl;
        foo("thread3");
        bar("thread3");
        bar("thread3");
    }
    void test()
    {
        thread t1(thread1), t2(thread2), t3(thread3);
        t1.join();
        t2.join();
        t3.join();
    }
}

// 二十六
namespace Expend_for_inline
{
    class X
    {
    public:
        inline static std::string test{ "a_test" };
        //用inline实现static成员声明、定义，不然如果放到头文件类外定义，有可能会多次include定义，导致链接错误
    };

    void test()
    {
        cout << X::test << endl;
    }

}

// 二十七
namespace Constant_Expression
{
    // constexpr的使用
    inline namespace Constexpr
    {
        // 基本使用
        constexpr int abs(int x)
        {
            if (x >= 0)
                return x;
            else
            {
                return -x;
            }
        }
        constexpr int sum(int x)
        {
            int result = 0;
            while (x > 0)
            {
                result += x--;
            }
            return result;
        }
        constexpr int next(int x)
        {
            return ++x;
        }

        class X
        {
            int x1;
        public:
            constexpr X():X(5){}
            constexpr X(int i) : x1(i)
            {
                if (i < 0)
                    x1 = -x1;
            }
            constexpr void set(int i)
            {
                x1 = i;
            }
            constexpr int get()
            {
                return x1;
            }
        };
        constexpr X make_x()
        {
            X x;
            x.set(66);
            return x;
        }

        // lambda中使用
        constexpr int foo()
        {
            // 如果满足条件，lambda表达式会隐式声明为constexpr
            // 如果显示声明lambda为constexpr，那么该表达式就一定要是一个常量表达式
            return []() {return 56; }();
        }

        // if constexpr的使用          该特性一般在模板中使用
        template<typename T>auto minus(T a, T b)
        {
            if constexpr (std::is_same<T, double>::value)   //如果有 && 判断，最好分多几个if进行嵌套
            {
                if (std::abs(a - b) < 0.0001)
                {
                    return 0.;
                }
                else
                {
                    return a - b;
                }
            }
            else    // 如果不用else而直接return (int)，那么在满足上面if时，就会导致多个不同的返回值类型
            {
                return static_cast<int>(a - b);
            }
        }

        // 虚函数的constexpr会被覆盖，也可覆盖没constexpr的虚函数

    }

    // consteval , constinit , is_constant_evaluated()
    namespace Constant_for_others
    {
        consteval int sqr(int n)
        {
            // 强迫函数是一个常量表达式，不会发生constexpr的不满足退化
            return n * n;
        }

        // 常量初始化
        constinit int x = 11;
        void test1()
        {
            static constinit int y = 22;
        }

        // is_constant_evaluated() 用来判断当前代码环境 是不是 常量求值环境

    }
    
}

// 二十八
namespace Sequence_of_Expression_Evalute
{
    void test()
    {
        std::string str = "but I have heared it works even if you don't believe in it";
        str.replace(0, 4, "").replace(str.find("even"), 4, "only").replace(str.find(" don't"), 6, "");
        cout << str << endl;
        /*
        * 在C++17前，该表达式求值顺序并不确定
        * 但现在，有明确的顺序:
        * 1.replace(0,4," ")
        * 2.tmp1 = find("even")
        * 3.replace(tmp1,4,"only")
        * 4.tmp2 = find(" don't")
        * 5.replace(tmp2,6,"")
        */
    }
}

// 二十九
namespace Iteral_Optimization
{
    // 十六进制 和 二进制 字面量优化
    void test1()
    {
        //std::hexfloat，将输出浮点数格式改为十六进制
        //std::defaultfloat，复原
        double fa1[]{ 1.11,2.22,3.33 };
        for (const auto& i : fa1)
            std::cout << std::hexfloat << i << std::defaultfloat << "\t" << i << endl;
        double fa2[]{ 0x1.7p+2,0x1.f4p+9,0x1.df3b64p-4 };
        for (const auto& i : fa2)
            std::cout << std::hexfloat << i << std::defaultfloat << "\t" << i << endl;
    }

    // 原生字面量
    void test2()
    {
        cout << R"(wd
                    \t\t\thaha nmd")" << endl;
        char8_t utf8[] = u8R"(芜湖起飞)";
        cout << R"cpp(前后有这样一个cpp对齐，那么里面就可以放很多个)而不怕提前结束)cpp" << endl;
    }

    // 用户自定义字面量
	class Num1
	{
	public:
		unsigned long long a = 2;
	};

    Num1 operator "" _num1(unsigned long long n)
    {
        return Num1{ n };
    }

    void test3()
    {
        auto nn = 777_num1;
        cout << nn.a << endl;
    }
}

// 三十
namespace Struct_size_Align
{
    struct X
    {
        char a1;
        int a2;
        double a3;
    };

    struct X1
    {
        alignas(16) char a1;
        alignas(double) int a2;
        double a3;
    };

    struct alignas(16) X2   //如果这里 alignas的值比 最大单个成员变量的对齐值小，就按成员变量的来
    {
        char a1;
        alignas(8) int a2;
        double a3;
    };

    // alignas 和 alignof 的基本用法
    void test1()
    {
        auto x11 = alignof(int);
        auto x22 = alignof(void(*)());

        // alignof 不能推导变量 ，GCC扩展了这条规则
        //int a = 0;    auto x33 = alignof(a);

        // alignof 推导decltype只有默认对齐才是正确的
        //alignas(8) int a; auto x44 = alignof(decltype(a));

        X x;
        X1 x1;
        X2 x2;
        //alignas(4) X2 x3; 直接报错了。。
        alignas(32) X2 x4;

        cout << sizeof(x) << endl;      // 16
        cout << sizeof(x1) << endl;     // 32
        cout << sizeof(x2) << endl;     // 32
        cout << sizeof(x4) << endl;     // 32
        cout << sizeof(x4.a2) << endl;  // 4
        cout << sizeof(x2.a2) << endl;  // 4
    }

    // 一些其它关于对齐字节长度的用法
    void test2()
    {
        // alignment_of：类似于 alignof 的模板化实现
        std::cout << std::alignment_of<int>::value << std::endl;

        // aligned_storage：用来指定分配对齐字节长度和大小的内存
        //std::aligned_storage<128, 16>::type buffer{};     vs有兼容性问题，除非真的需要用
        //buffer的内存大小为128，对齐字节长度为16
    }

}

// 三十一
namespace Property
{
    
    // 属性语法
        // 属性表示：[[attr]] [[attr1,attr2,attr3(args)]] [[namespace::attr(args)]]
    [[using gnu: always_inline,hot,const]][[nodiscard]]
    inline int f() {}

    // noreturn C++11, 与void不同，noreturn是直接中断被调用的地方的执行流
    namespace Noreturn
    {
        [[noreturn]] void foo() {}
        void bar() {}
        void test()
        {
            foo();
            bar();  //bar不会执行，因为foo为noreturn，test在运行完foo后就中断了
        }
    }

    // carries_dependency C++11
    // 允许跨函数传递内存依赖项，用于弱内存顺序架构平台上多线程程序优化

    // deprecated C++14, 声明某个实体被弃用
    namespace Deprecated
    {
        [[deprecated("foo was deprecated,use bar instead")]] void foo() {}
        class [[deprecated]] X {};
        void test()
        {
            //X x;      报错，被声明为已否决
            //foo();    报错，foo was depre......
        }
    }

    // fallthrough C++17, 用于switch语句的上下文，让编译器不需要给出警告
    void fallthrough_test(int a)
    {
        switch (a)
        {
        case 0:break;
        case 1:cout << "111" << endl; [[fallthrough]];
        case 2:cout << "accept 1 or 2" << endl;
        default:break;
        }
    }

    // nodiscard C++17, 声明函数的返回值不应该被舍弃，并让编译器给出警告   ，返回的引用类型不起作用
    namespace Nodiscard
    {
        class X
        {
        public:
            [[nodiscard("nodiscard test for class X")]] X() { cout << "ctor" << endl; }
            X(int x) { cout << x << " ctor" << endl; }
        };
        [[nodiscard]] int nodiscard_foo() { return 1; }
        class [[nodiscard]] X1 {};
        X1 nodiscard_bar() { return X1{}; }
        X1& nodiscard_ref(X1& x) { return x; }
        void nodiscard_test()
        {
            X x;        //构造非临时对象，没问题
            X{};        //构造了临时对象，给出警告
            X{ 123 };   //构造函数不是nodiscard，没问题
            nodiscard_foo();        //函数被声明为nodiscard,警告
            nodiscard_bar();        //函数返回的class为nodiscard，警告
            X1 x1{};
            nodiscard_ref(x1);      //nodiscard对应用没影响
        }
    }

    // maybe_unused C++17, 声明该实体可能不被使用，消除编译器报错
    namespace Maybe_Unused
    {
        int foo(int a [[maybe_unused]], int b [[maybe_unused]] )   
        {
            return 55;
        }

        void test()
        {
            foo(1, 2);
        }
    }

    // likely   unlikely        C++20
    // likely允许编译器对属性所在的执行路径相对于其他路径进行优化

    // no_unique_address C++20, 指示编译器该数据成员不需要唯一地址
    namespace No_Unique_Address
    {
        struct Empty {};
        struct X {
            int i;
            [[no_unique_address]] Empty e;
            //这样声明后，e会和i使用同一地址，不过不能Empty e1,e2放一起
            // 这样在使用一些函数对象作为成员变量时，就不需要额外占用额外内存地址空间
        };
    }

} 

// 三十二
namespace Pre_Macro
{
    // 预处理器 _has_include        用于判断某个头文件是否可以被include
#if __has_include(<optional>)
#include <optional>
#   define have_optional 1
#elif __has_include(<experimental/optional>)
#    include <experimental/optional>
#    define have_optional 1
#    define experimental/_optional 1
#else
#    define have_optional 0
#endif

    // 属性特性测试宏
#if defined(__has_cpp_attribute)
    #if __has_cpp_attribute(deprecated)
        #define mtest 1
#endif
#else
#   define mtest 0
#endif

    void test1()
    {
        //cout << __has_cpp_attribute(nodiscard) << endl;   不能这样使用，只能放到预编译部分使用
    }

    // 语言特性宏 和 标准库功能宏 
    //__VA_ARGS__宏，常用与打印日志
}

// 三十三
#include <chrono>
#include <future>
#include <experimental/generator>
namespace Coroutine
{
    /*
    *   co_await:触发一个挂起点
    *   co_return:设置返回值，触发挂起点的恢复
    *   co_yield:从上次的挂起点恢复
    */

    // 实现原理？？？？
}

// 三十四
namespace Optimization_for_Basic_Attribute
{
    // 显示自定义类型的类型转换
    namespace Type_cast
    {
        template<typename T>
        class SomeStorage
        {
        public:
            SomeStorage() = default;
            SomeStorage(std::initializer_list<T> l) :data_(l) {}
            explicit operator bool() { return !data_.empty(); }
        private:
            vector<T> data_;
        };
        void test()
        {
            SomeStorage<double> s1{ 1.,2.,3. };
            SomeStorage<int> s2{ 1,2,3 };
            cout << std::boolalpha;
            // cout << "s1 == s2 :" << (s1 == s2) << endl; 报错，无===运算符
            // cout << "s1 + s2 :" << (s1 + s2) << endl;   报错，无+运算符
            cout << "s1 : " << static_cast<bool>(s1) << endl;
            cout << "s1 : " << static_cast<bool>(s2) << endl;
            if (s1)     // 对bool类型判断，可以进行隐式转换
            {
                cout << "YES" << endl;
            }
        }
    }

    // std::launder()：用来 防止编译器追踪到数据的来源以阻止编译器对数据的优化？？

    // 返回值优化，编译器会将函数返回的对象直接构造到它们本来要存储的变量空间而不产生临时变量
    // 不过尽量别依赖编译器优化

    //C++20放宽了operator==的标准，可以friend operator==(C,C)    //class C

    //......
}

// 三十五
namespace Args_Template_package
{

    template<typename T>
    T baz(T t)
    {
        cout << t << "\t" << typeid(t).name() << endl;
        return t;
    }
    template<typename T1,typename T2>
    T1 baz(T1 t1,T2 t2)
    {
        cout << typeid(t1).name() << ",\t" << typeid(t2).name() << endl;
        return t1;
    }
    template<class ...Args>
    int baz(Args ...args)
    {
        return 0;
    }

    template<class ...Args>
    void foo(Args ...args) { cout << "here is foo" << endl; }

    template<class ...Args>
    void run1(Args ...args) {
        foo(baz(args)...);      // 形参包展开
        //foo(baz(&args, args)...);
        // 通过一个参数模板函数接收args途中调用/遍历args
    }

    template<class ...Args>
    void run2(Args ...args)
    {
        //foo(baz(args...) + args...);
        int tmp[] = { (cout << args << endl,0) ...};
        // 通过逗号，表达式的特性，可以去遍历args里的东西
    }

    int add(int a, int b)
    {
        return a + b;
    }
    int sub(int a, int b)
    {
        return a - b;
    }
    template<class ...Args>
    void foo(Args(*...args)(int, int))
    {
        // 形参包的特化？
        int tmp[] = { (cout << args(9,7) << endl,0)... };
    }

    // 形参包展开
    void test1()
    {
        run1(111, 2., "run1");
        run2(1, 2., 3);
        foo(add, sub);
    }



    template <class ...Args>
    class derived : public Args...
    {
    public:
        derived(const Args& ...args) : Args(args)...{}
        // 当 derived被当作基类继承时，因为它是Args的，所以在该继承中
        // class son : public derived<Args>...
        // 类中可以public:using base<Args>::base...;    去打开基类构造函数
    };
    class base1 {public: base1() = default; base1(const base1&) { cout << "base1 copy ctor" << endl; } };
    class base2 {public: base2() = default; base2(const base2&) { cout << "base2 copy ctor" << endl; } };
    // 类的继承中形参包的展开
    void test2()
    {
        base1 b1;
        base2 b2;
        derived<base1, base2> d(b1, b2);
    }



    template<class...>  struct Tuple {};
    template<typename T1,typename T2> struct Pair{};
    template<class ...Args1>
    struct zip
    {
        template<class ...Args2>        //Args1要和Args2包的长度相同
        struct with {
            using type = Tuple<Pair<Args1, Args2>...>;
        };
    };
    // 多个 Args 作用于同一个类时
    void test3()
    {
        zip<short, int>::with<unsigned short, unsigned>::type t;    
        // t的类型为Tuple<Pair<short,unsigned short>,Pair<int,unsigned>>
    }

    template<class ...Args>
    void foo2(Args ...args)
    {
        cout << "foo2 sizeof...(args) = " << sizeof...(args) << endl;
    }

    // sizeof...的使用
    void test4()
    {
        foo2();
        foo2(1, 2, 3, "test");
    }



    template<class ...Args>
    auto sum1(Args ...args)
    {
        return (args + ...);    //一元向右叠折叠
        // arg0 + (arg1 + (...))
    }

    template<class ...Args>
    auto sum2(Args ...args)
    {
        return (... + args);    //一元向左叠折叠
    }

    template<class ...Args>
    auto sum4(Args ...args)
    {
        return (123 + ... + args);  //二元向左.可以给上一个参数
    }
    // 折叠表达式
    void test5()
    {
        cout << sum1(1, 2, 3, 4, 5) << endl;    //15
        cout << sum2(string("here"), " is", " args", " test") << endl;      //如果这里使用向右，就会出错，变成后面两个const char*相加
        cout << sum4(1, 2, 3) << endl;          //129
    }

}

// 三十六
// C++20对typename做了些优化

// 三十七
namespace Optimization_for_Template_Args2
{
    // 1.允许常量求值作为所有非类型模板参数的实参
        // 非类型模板形参使用的实参可以是该模板形参类型的任何经转换常量表达式

    // 2.允许局部和匿名类型作为模板实参
    
    // 3.允许函数模板的默认模板参数, 同时对函数模板的默认参数不作从左到右的要求
        // template<typename T = double>

    // 4.函数模板添加ADL查找规则
        // 对于在namespace N里的一个类A， int x = f<N::A>(N::A())

    // 5.允许非类型模板形参中的字面量类类型
        // template<A a>

    // 6.扩展的模板参数匹配类型
        // 使用 auto占位符
}

// 三十八
namespace Class_Template_Argument_deduction
{
    template<typename T>
    struct t
    {
        T func;
        t(T t) :func(t) { func(); }
    };

    void test1()
    {
        // 通过初始化构造推导类模板实参
        // auto tp = std::make_tuple(5,11.,"test");
        std::tuple tp{ 5,11.,"test" };
        std::mutex mx;
        std::lock_guard lg(mx);
        unique_ptr<vector<int>> sp(new std::vector{ 1,2,3,4 });

        // 要不就全部推导，要不就全部指定，不能推导一部分

        std::tuple tp2{ tp };   //如果是单一同类型的，优先使用Copy

        // lambda也能推导
        t tt{ []() {std::cout << "run test" << std::endl; } };

    }
}

// 三十九
namespace Custom_Type_deduction
{
    template<typename T1,typename T2>
    struct MyPair
    {
        MyPair(const T1& t1,const T2& t2):first(t1), second(t2) {}
        T1 first;
        T2 second;
    };
    template<typename T1, typename T2>
    MyPair(T1, T2)->MyPair<T1, T2>;

    MyPair(int, const char*)->MyPair<long long, std::string>;
    
    template<typename T1, typename T2>
    MyPair<T1,T2> make_mypair(T1 x, T2 y)
    {
        return MyPair<T1, T2>(x, y);
    }
    
    void test1()
    {
        MyPair p1 = make_mypair(4, 5.23);
    }

}

// 四十
namespace SFINAE
{
    // 可以通过 SFINAE规则通过编译错误去判断某类型是否符合
    class Obj1
    {
    public:
        void f() const { cout << "run f()" << endl; }
    };
    class Obj2{    };
    template<typename T>
    auto DumpObj(const T& t)->decltype(((void)t.f()), void())
    {
        t.f();
    }
    void DumpObj(...)
    {
        cout << "haven't obj.f()" << std::endl;
    }
    void test()
    {
        DumpObj(Obj1());
        DumpObj(Obj2());
    }
}

// 四十一
namespace Concept_and_Constraint
{
    // std::enable_if
    template <typename T,class U = std::enable_if_t<std::is_integral_v<T>>>
    struct X {};
    // 当约束条件满足时，X类型为X<int,void>,不然会因为U类型不符合语法规范，编译错误

    // 概念 concept的使用
    template <class C>
    concept IntegerType = std::is_integral_v<C>;

    template<IntegerType C>
    struct Cx {};

    void test1()
    {
        Cx<int> c1;
        //Cx<double> c2;    报错
    }

    namespace Requires
    {
        constexpr bool bar() { return true; }
        template<class T>
        requires (bar())    //不能不用()括住bar(),因为bar()不是初等表达式
        struct X1 {};

        template<class T>
        void foo() requires (bar());    // 可以放在末尾使用requires
        // requires在不同的位置有先后执行顺序

        template<class T>
        concept Check = requires(T a, T b)
        {
            a.clear();
            a + b;      //需要满足a+b才能通过编译
        };

    }

}

int main()
{
    //Auto_usage::test8();
    //Decltype_usage
    //Rvalue::test2();
    //Initializer_List::test1();
    //Enum::test1();
    //Override_AND_Final::test();
    //for_base_on_range::test3();
    //init_for_judge::test3();
    //Tuple_Bind::test1();
    //Noexception::test2();
    //Thread_Local::test();
    //Expend_for_inline::test();
    //Sequence_of_Expression_Evalute::test();
    //Iteral_Optimization::test3();
    //Struct_size_Align::test1();
    //Property::test();
    //Pre_Macro::test1();
    //Args_Template_package::test5();
    //Class_Template_Argument_deduction::test1();
    //Custom_Type_deduction::test1();
    //SFINAE::test();

}

