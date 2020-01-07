package com.lintcode.problem.January2019;

import java.lang.reflect.Array;
import java.util.*;

/*
Description
中文
给出一个有n个整数的数组S，在S中找到三个整数a, b, c，找到所有使得a + b + c = 0的三元组
English
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {
    List<List<Integer>> results=new ArrayList<>();

    class ListComparator<T extends Comparable<T>> implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> o1, List<Integer> o2) {
            for(int i=0;i<Math.min(o1.size(),o2.size());i++){
                int c=o1.get(i).compareTo(o2.get(i));
                if(c!=0){
                    return c;
                }
            }
            return Integer.compare(o1.size(),o2.size());
        }
    }

    //find all unique pairs such that A[i]+A[j]=S,and i<=j<=right
    private void twoSum(int[] A,int right,int S){
        int i,j=right;
        for(i=0;i<=right;++i){
            if(i>0&&A[i]==A[i-1]){
                continue;
            }
            while(j>i&&A[j]>S-A[i]){
                --j;
            }

            if(i>=j){
                break;
            }

            if(A[i]+A[j]==S){
                List<Integer> t=new ArrayList<>();
                t.add(A[i]);
                t.add(A[j]);
                t.add(-S);//t.add(A[right+1])
                results.add(t);

            }
        }
    }

    public List<List<Integer>> treeSum(int[] A){
        if(A==null||A.length<3){
            return results;
        }
        Arrays.sort(A);
        int i,n=A.length;
        for(i=2;i<n;++i){
            if(i+1<n&&A[i+1]==A[i]){
                continue;
            }
            twoSum(A,i-1,-A[i]);
        }
        Collections.sort(results,new ListComparator<>());
        return results;
    }
}
