package com.java.tessThread;

public class TestLambda {

    // 静态内部类
    static class ILike implements Like {
        @Override
        public void lambda() {
            System.out.println("静态内部类");
        }
    }

    public static void main(String[] args) {

        // 局部内部类
        class ILike implements Like {
            @Override
            public void lambda() {
                System.out.println("局部内部类");
            }
        }


        // 匿名内部类
        new Like(){
            @Override
            public void lambda() {
                System.out.println("匿名内部类");
            }
        };


        // lambda
        Like like = ()-> {
            System.out.println("我是 Like");
        };
        like.lambda();
    }
}

interface Like {
    void lambda();
}

// 实现类

class ILike implements Like {
    @Override
    public void lambda() {
        System.out.println("实现类");
    }
}


