package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;

class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem system, int orientation) {
        ChainHead[] chainsArray;
        int chainsSize;
        int offset;
        if (orientation == 0) {
            offset = 0;
            chainsSize = constraintWidgetContainer.mHorizontalChainsSize;
            chainsArray = constraintWidgetContainer.mHorizontalChainsArray;
        } else {
            offset = 2;
            chainsSize = constraintWidgetContainer.mVerticalChainsSize;
            chainsArray = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i = 0; i < chainsSize; i++) {
            ChainHead first = chainsArray[i];
            first.define();
            if (!constraintWidgetContainer.optimizeFor(4)) {
                applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
            } else if (!Optimizer.applyChainOptimized(constraintWidgetContainer, system, orientation, offset, first)) {
                applyChainConstraints(constraintWidgetContainer, system, orientation, offset, first);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:266:0x05eb A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x05f4  */
    /* JADX WARNING: Removed duplicated region for block: B:295:0x0676  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer r61, android.support.constraint.solver.LinearSystem r62, int r63, int r64, android.support.constraint.solver.widgets.ChainHead r65) {
        /*
            r0 = r61
            r10 = r62
            r12 = r65
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r12.mFirst
            android.support.constraint.solver.widgets.ConstraintWidget r14 = r12.mLast
            android.support.constraint.solver.widgets.ConstraintWidget r9 = r12.mFirstVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r8 = r12.mLastVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r7 = r12.mHead
            r1 = r13
            r2 = 0
            r3 = 0
            float r4 = r12.mTotalWeight
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r12.mFirstMatchConstraintWidget
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r12.mLastMatchConstraintWidget
            r15 = r1
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r1 = r0.mListDimensionBehaviors
            r1 = r1[r63]
            r16 = r2
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r2 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r17 = r3
            if (r1 != r2) goto L_0x0028
            r1 = 1
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r19 = r1
            r1 = 0
            r2 = 0
            r20 = 0
            if (r63 != 0) goto L_0x0054
            int r3 = r7.mHorizontalChainStyle
            if (r3 != 0) goto L_0x0037
            r3 = 1
            goto L_0x0038
        L_0x0037:
            r3 = 0
        L_0x0038:
            r1 = r3
            int r3 = r7.mHorizontalChainStyle
            r23 = r1
            r1 = 1
            if (r3 != r1) goto L_0x0042
            r1 = 1
            goto L_0x0043
        L_0x0042:
            r1 = 0
        L_0x0043:
            int r2 = r7.mHorizontalChainStyle
            r3 = 2
            if (r2 != r3) goto L_0x004a
            r2 = 1
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            r3 = r15
            r20 = r16
            r24 = r23
        L_0x0050:
            r16 = r1
            r15 = r2
            goto L_0x0072
        L_0x0054:
            int r3 = r7.mVerticalChainStyle
            if (r3 != 0) goto L_0x005a
            r3 = 1
            goto L_0x005b
        L_0x005a:
            r3 = 0
        L_0x005b:
            r1 = r3
            int r3 = r7.mVerticalChainStyle
            r24 = r1
            r1 = 1
            if (r3 != r1) goto L_0x0065
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            int r2 = r7.mVerticalChainStyle
            r3 = 2
            if (r2 != r3) goto L_0x006d
            r2 = 1
            goto L_0x006e
        L_0x006d:
            r2 = 0
        L_0x006e:
            r3 = r15
            r20 = r16
            goto L_0x0050
        L_0x0072:
            if (r17 != 0) goto L_0x014d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r3.mListAnchors
            r1 = r1[r64]
            r22 = 4
            if (r19 != 0) goto L_0x007e
            if (r15 == 0) goto L_0x0080
        L_0x007e:
            r22 = 1
        L_0x0080:
            int r23 = r1.getMargin()
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            if (r2 == 0) goto L_0x0092
            if (r3 == r13) goto L_0x0092
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r1.mTarget
            int r2 = r2.getMargin()
            int r23 = r23 + r2
        L_0x0092:
            r2 = r23
            if (r15 == 0) goto L_0x009d
            if (r3 == r13) goto L_0x009d
            if (r3 == r9) goto L_0x009d
            r22 = 6
            goto L_0x00a3
        L_0x009d:
            if (r24 == 0) goto L_0x00a3
            if (r19 == 0) goto L_0x00a3
            r22 = 4
        L_0x00a3:
            r27 = r4
            r4 = r22
            r28 = r5
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.mTarget
            if (r5 == 0) goto L_0x00d6
            if (r3 != r9) goto L_0x00be
            android.support.constraint.solver.SolverVariable r5 = r1.mSolverVariable
            r29 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r1.mTarget
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r30 = r7
            r7 = 5
            r10.addGreaterThan(r5, r6, r2, r7)
            goto L_0x00cc
        L_0x00be:
            r29 = r6
            r30 = r7
            android.support.constraint.solver.SolverVariable r5 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r1.mTarget
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r7 = 6
            r10.addGreaterThan(r5, r6, r2, r7)
        L_0x00cc:
            android.support.constraint.solver.SolverVariable r5 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r1.mTarget
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r10.addEquality(r5, r6, r2, r4)
            goto L_0x00da
        L_0x00d6:
            r29 = r6
            r30 = r7
        L_0x00da:
            if (r19 == 0) goto L_0x0116
            int r5 = r3.getVisibility()
            r6 = 8
            if (r5 == r6) goto L_0x0102
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r5 = r3.mListDimensionBehaviors
            r5 = r5[r63]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r6 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r5 != r6) goto L_0x0102
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r3.mListAnchors
            int r6 = r64 + 1
            r5 = r5[r6]
            android.support.constraint.solver.SolverVariable r5 = r5.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r3.mListAnchors
            r6 = r6[r64]
            android.support.constraint.solver.SolverVariable r6 = r6.mSolverVariable
            r31 = r1
            r1 = 5
            r7 = 0
            r10.addGreaterThan(r5, r6, r7, r1)
            goto L_0x0105
        L_0x0102:
            r31 = r1
            r7 = 0
        L_0x0105:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r3.mListAnchors
            r1 = r1[r64]
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r5 = r0.mListAnchors
            r5 = r5[r64]
            android.support.constraint.solver.SolverVariable r5 = r5.mSolverVariable
            r6 = 6
            r10.addGreaterThan(r1, r5, r7, r6)
            goto L_0x0118
        L_0x0116:
            r31 = r1
        L_0x0118:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r3.mListAnchors
            int r5 = r64 + 1
            r1 = r1[r5]
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x0138
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r1.mOwner
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            r6 = r6[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x0136
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r5.mListAnchors
            r6 = r6[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 == r3) goto L_0x0139
        L_0x0136:
            r5 = 0
            goto L_0x0139
        L_0x0138:
            r5 = 0
        L_0x0139:
            r20 = r5
            if (r20 == 0) goto L_0x0140
            r3 = r20
            goto L_0x0143
        L_0x0140:
            r1 = 1
            r17 = r1
        L_0x0143:
            r4 = r27
            r5 = r28
            r6 = r29
            r7 = r30
            goto L_0x0072
        L_0x014d:
            r27 = r4
            r28 = r5
            r29 = r6
            r30 = r7
            if (r8 == 0) goto L_0x017d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r1.mTarget
            if (r1 == 0) goto L_0x017d
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            android.support.constraint.solver.SolverVariable r2 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r64 + 1
            r4 = r4[r5]
            android.support.constraint.solver.widgets.ConstraintAnchor r4 = r4.mTarget
            android.support.constraint.solver.SolverVariable r4 = r4.mSolverVariable
            int r5 = r1.getMargin()
            int r5 = -r5
            r6 = 5
            r10.addLowerThan(r2, r4, r5, r6)
            goto L_0x017e
        L_0x017d:
            r6 = 5
        L_0x017e:
            if (r19 == 0) goto L_0x019e
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r4 = r64 + 1
            r2 = r2[r4]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r14.mListAnchors
            int r5 = r64 + 1
            r4 = r4[r5]
            int r4 = r4.getMargin()
            r5 = 6
            r10.addGreaterThan(r1, r2, r4, r5)
        L_0x019e:
            java.util.ArrayList<android.support.constraint.solver.widgets.ConstraintWidget> r7 = r12.mWeightedMatchConstraintsWidgets
            if (r7 == 0) goto L_0x026d
            int r1 = r7.size()
            r2 = 1
            if (r1 <= r2) goto L_0x026d
            r4 = 0
            r5 = 0
            boolean r2 = r12.mHasUndefinedWeights
            if (r2 == 0) goto L_0x01b8
            boolean r2 = r12.mHasComplexMatchWeights
            if (r2 != 0) goto L_0x01b8
            int r2 = r12.mWidgetsMatchCount
            float r2 = (float) r2
            r27 = r2
        L_0x01b8:
            r2 = 0
        L_0x01b9:
            if (r2 >= r1) goto L_0x026d
            java.lang.Object r21 = r7.get(r2)
            r6 = r21
            android.support.constraint.solver.widgets.ConstraintWidget r6 = (android.support.constraint.solver.widgets.ConstraintWidget) r6
            float[] r0 = r6.mWeight
            r0 = r0[r63]
            r21 = 0
            int r22 = (r0 > r21 ? 1 : (r0 == r21 ? 0 : -1))
            if (r22 >= 0) goto L_0x01fc
            r41 = r0
            boolean r0 = r12.mHasComplexMatchWeights
            if (r0 == 0) goto L_0x01f1
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r6.mListAnchors
            int r21 = r64 + 1
            r0 = r0[r21]
            android.support.constraint.solver.SolverVariable r0 = r0.mSolverVariable
            r42 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            r1 = r1[r64]
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            r43 = r3
            r3 = 4
            r44 = r7
            r7 = 0
            r10.addEquality(r0, r1, r7, r3)
            r3 = 0
            r7 = 6
            goto L_0x0260
        L_0x01f1:
            r42 = r1
            r43 = r3
            r44 = r7
            r0 = 1065353216(0x3f800000, float:1.0)
            r41 = r0
            goto L_0x0204
        L_0x01fc:
            r41 = r0
            r42 = r1
            r43 = r3
            r44 = r7
        L_0x0204:
            int r0 = (r41 > r21 ? 1 : (r41 == r21 ? 0 : -1))
            if (r0 != 0) goto L_0x021c
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r6.mListAnchors
            int r1 = r64 + 1
            r0 = r0[r1]
            android.support.constraint.solver.SolverVariable r0 = r0.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            r1 = r1[r64]
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            r3 = 0
            r7 = 6
            r10.addEquality(r0, r1, r3, r7)
            goto L_0x0260
        L_0x021c:
            r3 = 0
            r7 = 6
            if (r4 == 0) goto L_0x0259
            android.support.constraint.solver.widgets.ConstraintAnchor[] r0 = r4.mListAnchors
            r0 = r0[r64]
            android.support.constraint.solver.SolverVariable r0 = r0.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r4.mListAnchors
            int r18 = r64 + 1
            r1 = r1[r18]
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r6.mListAnchors
            r3 = r3[r64]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r6.mListAnchors
            int r18 = r64 + 1
            r7 = r7[r18]
            android.support.constraint.solver.SolverVariable r7 = r7.mSolverVariable
            r46 = r4
            android.support.constraint.solver.ArrayRow r4 = r62.createRow()
            r33 = r4
            r34 = r5
            r35 = r27
            r36 = r41
            r37 = r0
            r38 = r1
            r39 = r3
            r40 = r7
            r33.createRowEqualMatchDimensions(r34, r35, r36, r37, r38, r39, r40)
            r10.addConstraint(r4)
            goto L_0x025b
        L_0x0259:
            r46 = r4
        L_0x025b:
            r0 = r6
            r1 = r41
            r4 = r0
            r5 = r1
        L_0x0260:
            int r2 = r2 + 1
            r1 = r42
            r3 = r43
            r7 = r44
            r0 = r61
            r6 = 5
            goto L_0x01b9
        L_0x026d:
            r43 = r3
            r44 = r7
            if (r9 == 0) goto L_0x031e
            if (r9 == r8) goto L_0x0284
            if (r15 == 0) goto L_0x0278
            goto L_0x0284
        L_0x0278:
            r0 = r8
            r10 = r9
            r33 = r28
            r28 = r30
            r30 = r43
            r34 = r44
            goto L_0x0328
        L_0x0284:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r64 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r3 = r3[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x029f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r13.mListAnchors
            r3 = r3[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02a0
        L_0x029f:
            r3 = 0
        L_0x02a0:
            r18 = r3
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r64 + 1
            r3 = r3[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            if (r3 == 0) goto L_0x02b7
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r64 + 1
            r3 = r3[r4]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r3.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x02b8
        L_0x02b7:
            r3 = 0
        L_0x02b8:
            r21 = r3
            if (r9 != r8) goto L_0x02c6
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r9.mListAnchors
            r1 = r3[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r9.mListAnchors
            int r4 = r64 + 1
            r2 = r3[r4]
        L_0x02c6:
            r7 = r1
            r6 = r2
            if (r18 == 0) goto L_0x030d
            if (r21 == 0) goto L_0x030d
            r1 = 1056964608(0x3f000000, float:0.5)
            if (r63 != 0) goto L_0x02d7
            r5 = r30
            float r1 = r5.mHorizontalBiasPercent
        L_0x02d4:
            r22 = r1
            goto L_0x02dc
        L_0x02d7:
            r5 = r30
            float r1 = r5.mVerticalBiasPercent
            goto L_0x02d4
        L_0x02dc:
            int r23 = r7.getMargin()
            int r25 = r6.getMargin()
            android.support.constraint.solver.SolverVariable r2 = r7.mSolverVariable
            android.support.constraint.solver.SolverVariable r4 = r6.mSolverVariable
            r26 = 5
            r1 = r10
            r30 = r43
            r3 = r18
            r31 = r4
            r4 = r23
            r33 = r28
            r28 = r5
            r5 = r22
            r32 = r6
            r6 = r21
            r35 = r7
            r34 = r44
            r7 = r31
            r0 = r8
            r8 = r25
            r10 = r9
            r9 = r26
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0317
        L_0x030d:
            r0 = r8
            r10 = r9
            r33 = r28
            r28 = r30
            r30 = r43
            r34 = r44
        L_0x0317:
            r59 = r14
            r14 = r10
            r10 = r62
            goto L_0x05e9
        L_0x031e:
            r0 = r8
            r10 = r9
            r33 = r28
            r28 = r30
            r30 = r43
            r34 = r44
        L_0x0328:
            if (r24 == 0) goto L_0x046e
            if (r10 == 0) goto L_0x046e
            r1 = r10
            r2 = r10
            int r3 = r12.mWidgetsMatchCount
            if (r3 <= 0) goto L_0x033b
            int r3 = r12.mWidgetsCount
            int r4 = r12.mWidgetsMatchCount
            if (r3 != r4) goto L_0x033b
            r45 = 1
            goto L_0x033d
        L_0x033b:
            r45 = 0
        L_0x033d:
            r9 = r1
            r8 = r2
        L_0x033f:
            if (r9 == 0) goto L_0x0461
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r9.mListNextVisibleWidget
            r7 = r1[r63]
            if (r7 != 0) goto L_0x0357
            if (r9 != r0) goto L_0x034a
            goto L_0x0357
        L_0x034a:
            r35 = r7
            r36 = r8
            r37 = r9
            r53 = r14
            r14 = r10
            r10 = r62
            goto L_0x0456
        L_0x0357:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            r6 = r1[r64]
            android.support.constraint.solver.SolverVariable r5 = r6.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x0366
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x0367
        L_0x0366:
            r1 = 0
        L_0x0367:
            if (r8 == r9) goto L_0x0374
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r64 + 1
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r1 = r2.mSolverVariable
        L_0x0371:
            r18 = r1
            goto L_0x038c
        L_0x0374:
            if (r9 != r10) goto L_0x0371
            if (r8 != r9) goto L_0x0371
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x0389
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r13.mListAnchors
            r2 = r2[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            goto L_0x038a
        L_0x0389:
            r2 = 0
        L_0x038a:
            r1 = r2
            goto L_0x0371
        L_0x038c:
            r1 = 0
            r2 = 0
            r3 = 0
            int r4 = r6.getMargin()
            r48 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r20 = r64 + 1
            r1 = r1[r20]
            int r1 = r1.getMargin()
            if (r7 == 0) goto L_0x03bc
            r49 = r2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            r2 = r2[r64]
            r50 = r3
            android.support.constraint.solver.SolverVariable r3 = r2.mSolverVariable
            r51 = r2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r20 = r64 + 1
            r2 = r2[r20]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            r21 = r2
            r20 = r3
            r3 = r51
            goto L_0x03df
        L_0x03bc:
            r49 = r2
            r50 = r3
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r14.mListAnchors
            int r3 = r64 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x03cd
            android.support.constraint.solver.SolverVariable r3 = r2.mSolverVariable
            goto L_0x03cf
        L_0x03cd:
            r3 = r49
        L_0x03cf:
            r52 = r2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r20 = r64 + 1
            r2 = r2[r20]
            android.support.constraint.solver.SolverVariable r2 = r2.mSolverVariable
            r21 = r2
            r20 = r3
            r3 = r52
        L_0x03df:
            if (r3 == 0) goto L_0x03e6
            int r2 = r3.getMargin()
            int r1 = r1 + r2
        L_0x03e6:
            r22 = r1
            if (r8 == 0) goto L_0x03f5
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r4 = r4 + r1
        L_0x03f5:
            r23 = r4
            if (r5 == 0) goto L_0x044b
            if (r18 == 0) goto L_0x044b
            if (r20 == 0) goto L_0x044b
            if (r21 == 0) goto L_0x044b
            r1 = r23
            if (r9 != r10) goto L_0x040b
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r10.mListAnchors
            r2 = r2[r64]
            int r1 = r2.getMargin()
        L_0x040b:
            r25 = r1
            r1 = r22
            if (r9 != r0) goto L_0x041b
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            int r4 = r64 + 1
            r2 = r2[r4]
            int r1 = r2.getMargin()
        L_0x041b:
            r26 = r1
            r1 = 4
            if (r45 == 0) goto L_0x0421
            r1 = 6
        L_0x0421:
            r30 = r1
            r31 = 1056964608(0x3f000000, float:0.5)
            r4 = r10
            r10 = r62
            r1 = r10
            r2 = r5
            r52 = r3
            r3 = r18
            r53 = r14
            r14 = r4
            r4 = r25
            r32 = r5
            r5 = r31
            r31 = r6
            r6 = r20
            r35 = r7
            r7 = r21
            r36 = r8
            r8 = r26
            r37 = r9
            r9 = r30
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0456
        L_0x044b:
            r35 = r7
            r36 = r8
            r37 = r9
            r53 = r14
            r14 = r10
            r10 = r62
        L_0x0456:
            r8 = r37
            r9 = r35
            r10 = r14
            r20 = r35
            r14 = r53
            goto L_0x033f
        L_0x0461:
            r37 = r9
            r53 = r14
            r14 = r10
            r10 = r62
            r30 = r37
            r59 = r53
            goto L_0x05e9
        L_0x046e:
            r53 = r14
            r14 = r10
            r10 = r62
            if (r16 == 0) goto L_0x05e7
            if (r14 == 0) goto L_0x05e7
            r1 = r14
            r2 = r14
            int r3 = r12.mWidgetsMatchCount
            if (r3 <= 0) goto L_0x0486
            int r3 = r12.mWidgetsCount
            int r4 = r12.mWidgetsMatchCount
            if (r3 != r4) goto L_0x0486
            r45 = 1
            goto L_0x0488
        L_0x0486:
            r45 = 0
        L_0x0488:
            r9 = r1
            r8 = r2
        L_0x048a:
            if (r9 == 0) goto L_0x055f
            android.support.constraint.solver.widgets.ConstraintWidget[] r1 = r9.mListNextVisibleWidget
            r1 = r1[r63]
            if (r9 == r14) goto L_0x0552
            if (r9 == r0) goto L_0x0552
            if (r1 == 0) goto L_0x0552
            if (r1 != r0) goto L_0x0499
            r1 = 0
        L_0x0499:
            r7 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            r6 = r1[r64]
            android.support.constraint.solver.SolverVariable r5 = r6.mSolverVariable
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            if (r1 == 0) goto L_0x04a9
            android.support.constraint.solver.widgets.ConstraintAnchor r1 = r6.mTarget
            android.support.constraint.solver.SolverVariable r1 = r1.mSolverVariable
            goto L_0x04aa
        L_0x04a9:
            r1 = 0
        L_0x04aa:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r8.mListAnchors
            int r3 = r64 + 1
            r2 = r2[r3]
            android.support.constraint.solver.SolverVariable r4 = r2.mSolverVariable
            r1 = 0
            r2 = 0
            r3 = 0
            int r18 = r6.getMargin()
            r54 = r1
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r9.mListAnchors
            int r20 = r64 + 1
            r1 = r1[r20]
            int r1 = r1.getMargin()
            if (r7 == 0) goto L_0x04e2
            r55 = r2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r7.mListAnchors
            r2 = r2[r64]
            r56 = r3
            android.support.constraint.solver.SolverVariable r3 = r2.mSolverVariable
            r57 = r3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            if (r3 == 0) goto L_0x04dc
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x04dd
        L_0x04dc:
            r3 = 0
        L_0x04dd:
            r20 = r3
            r55 = r57
            goto L_0x04fe
        L_0x04e2:
            r55 = r2
            r56 = r3
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r9.mListAnchors
            int r3 = r64 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r2 = r2.mTarget
            if (r2 == 0) goto L_0x04f4
            android.support.constraint.solver.SolverVariable r3 = r2.mSolverVariable
            r55 = r3
        L_0x04f4:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r9.mListAnchors
            int r20 = r64 + 1
            r3 = r3[r20]
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            r20 = r3
        L_0x04fe:
            r3 = r2
            if (r3 == 0) goto L_0x0506
            int r2 = r3.getMargin()
            int r1 = r1 + r2
        L_0x0506:
            r21 = r1
            if (r8 == 0) goto L_0x0516
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r8.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            int r1 = r1.getMargin()
            int r18 = r18 + r1
        L_0x0516:
            r1 = 4
            if (r45 == 0) goto L_0x051a
            r1 = 6
        L_0x051a:
            r22 = r1
            if (r5 == 0) goto L_0x0548
            if (r4 == 0) goto L_0x0548
            if (r55 == 0) goto L_0x0548
            if (r20 == 0) goto L_0x0548
            r23 = 1056964608(0x3f000000, float:0.5)
            r1 = r10
            r11 = 5
            r2 = r5
            r25 = r3
            r3 = r4
            r26 = r4
            r4 = r18
            r30 = r5
            r5 = r23
            r23 = r6
            r6 = r55
            r31 = r7
            r7 = r20
            r32 = r8
            r8 = r21
            r35 = r9
            r9 = r22
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x054f
        L_0x0548:
            r31 = r7
            r32 = r8
            r35 = r9
            r11 = 5
        L_0x054f:
            r20 = r31
            goto L_0x0559
        L_0x0552:
            r32 = r8
            r35 = r9
            r11 = 5
            r20 = r1
        L_0x0559:
            r8 = r35
            r9 = r20
            goto L_0x048a
        L_0x055f:
            r32 = r8
            r35 = r9
            r11 = 5
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r9 = r1[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r13.mListAnchors
            r1 = r1[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r1.mTarget
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            int r2 = r64 + 1
            r7 = r1[r2]
            r6 = r53
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r6.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r1.mTarget
            if (r8 == 0) goto L_0x05c6
            if (r14 == r0) goto L_0x0597
            android.support.constraint.solver.SolverVariable r1 = r9.mSolverVariable
            android.support.constraint.solver.SolverVariable r2 = r8.mSolverVariable
            int r3 = r9.getMargin()
            r10.addEquality(r1, r2, r3, r11)
            r58 = r5
            r59 = r6
            r60 = r7
            r11 = r8
            r18 = r9
            goto L_0x05cf
        L_0x0597:
            if (r5 == 0) goto L_0x05c6
            android.support.constraint.solver.SolverVariable r2 = r9.mSolverVariable
            android.support.constraint.solver.SolverVariable r3 = r8.mSolverVariable
            int r4 = r9.getMargin()
            r18 = 1056964608(0x3f000000, float:0.5)
            android.support.constraint.solver.SolverVariable r1 = r7.mSolverVariable
            android.support.constraint.solver.SolverVariable r11 = r5.mSolverVariable
            int r21 = r7.getMargin()
            r22 = 5
            r23 = r1
            r1 = r10
            r58 = r5
            r5 = r18
            r59 = r6
            r6 = r23
            r60 = r7
            r7 = r11
            r11 = r8
            r8 = r21
            r18 = r9
            r9 = r22
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x05cf
        L_0x05c6:
            r58 = r5
            r59 = r6
            r60 = r7
            r11 = r8
            r18 = r9
        L_0x05cf:
            r1 = r58
            if (r1 == 0) goto L_0x05e4
            if (r14 == r0) goto L_0x05e4
            r2 = r60
            android.support.constraint.solver.SolverVariable r3 = r2.mSolverVariable
            android.support.constraint.solver.SolverVariable r4 = r1.mSolverVariable
            int r5 = r2.getMargin()
            int r5 = -r5
            r6 = 5
            r10.addEquality(r3, r4, r5, r6)
        L_0x05e4:
            r30 = r35
            goto L_0x05e9
        L_0x05e7:
            r59 = r53
        L_0x05e9:
            if (r24 != 0) goto L_0x05f2
            if (r16 == 0) goto L_0x05ee
            goto L_0x05f2
        L_0x05ee:
            r32 = r59
            goto L_0x0678
        L_0x05f2:
            if (r14 == 0) goto L_0x0676
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r14.mListAnchors
            r1 = r1[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r0.mListAnchors
            int r3 = r64 + 1
            r2 = r2[r3]
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            if (r3 == 0) goto L_0x0607
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r1.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0608
        L_0x0607:
            r3 = 0
        L_0x0608:
            r11 = r3
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            if (r3 == 0) goto L_0x0612
            android.support.constraint.solver.widgets.ConstraintAnchor r3 = r2.mTarget
            android.support.constraint.solver.SolverVariable r3 = r3.mSolverVariable
            goto L_0x0613
        L_0x0612:
            r3 = 0
        L_0x0613:
            r9 = r59
            if (r9 == r0) goto L_0x062c
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r9.mListAnchors
            int r5 = r64 + 1
            r4 = r4[r5]
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            if (r5 == 0) goto L_0x0628
            android.support.constraint.solver.widgets.ConstraintAnchor r5 = r4.mTarget
            android.support.constraint.solver.SolverVariable r5 = r5.mSolverVariable
            r47 = r5
            goto L_0x062a
        L_0x0628:
            r47 = 0
        L_0x062a:
            r3 = r47
        L_0x062c:
            r18 = r3
            if (r14 != r0) goto L_0x063a
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            r1 = r3[r64]
            android.support.constraint.solver.widgets.ConstraintAnchor[] r3 = r14.mListAnchors
            int r4 = r64 + 1
            r2 = r3[r4]
        L_0x063a:
            r8 = r1
            r7 = r2
            if (r11 == 0) goto L_0x0673
            if (r18 == 0) goto L_0x0673
            r21 = 1056964608(0x3f000000, float:0.5)
            int r22 = r8.getMargin()
            if (r0 != 0) goto L_0x0649
            r0 = r9
        L_0x0649:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r1 = r0.mListAnchors
            int r2 = r64 + 1
            r1 = r1[r2]
            int r23 = r1.getMargin()
            android.support.constraint.solver.SolverVariable r2 = r8.mSolverVariable
            android.support.constraint.solver.SolverVariable r6 = r7.mSolverVariable
            r25 = 5
            r1 = r10
            r3 = r11
            r4 = r22
            r5 = r21
            r26 = r6
            r6 = r18
            r31 = r7
            r7 = r26
            r26 = r8
            r8 = r23
            r32 = r9
            r9 = r25
            r1.addCentering(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0678
        L_0x0673:
            r32 = r9
            goto L_0x0678
        L_0x0676:
            r32 = r59
        L_0x0678:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Chain.applyChainConstraints(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):void");
    }
}
