package android.support.constraint.solver.widgets;

import android.support.constraint.solver.LinearSystem;
import android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour;

public class Optimizer {
    static final int FLAG_CHAIN_DANGLING = 1;
    static final int FLAG_RECOMPUTE_BOUNDS = 2;
    static final int FLAG_USE_OPTIMIZE = 0;
    public static final int OPTIMIZATION_BARRIER = 2;
    public static final int OPTIMIZATION_CHAIN = 4;
    public static final int OPTIMIZATION_DIMENSIONS = 8;
    public static final int OPTIMIZATION_DIRECT = 1;
    public static final int OPTIMIZATION_NONE = 0;
    public static final int OPTIMIZATION_RATIO = 16;
    public static final int OPTIMIZATION_STANDARD = 3;
    static boolean[] flags = new boolean[3];

    static void checkMatchParent(ConstraintWidgetContainer container, LinearSystem system, ConstraintWidget widget) {
        if (container.mListDimensionBehaviors[0] != DimensionBehaviour.WRAP_CONTENT && widget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_PARENT) {
            int left = widget.mLeft.mMargin;
            int right = container.getWidth() - widget.mRight.mMargin;
            widget.mLeft.mSolverVariable = system.createObjectVariable(widget.mLeft);
            widget.mRight.mSolverVariable = system.createObjectVariable(widget.mRight);
            system.addEquality(widget.mLeft.mSolverVariable, left);
            system.addEquality(widget.mRight.mSolverVariable, right);
            widget.mHorizontalResolution = 2;
            widget.setHorizontalDimension(left, right);
        }
        if (container.mListDimensionBehaviors[1] != DimensionBehaviour.WRAP_CONTENT && widget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_PARENT) {
            int top = widget.mTop.mMargin;
            int bottom = container.getHeight() - widget.mBottom.mMargin;
            widget.mTop.mSolverVariable = system.createObjectVariable(widget.mTop);
            widget.mBottom.mSolverVariable = system.createObjectVariable(widget.mBottom);
            system.addEquality(widget.mTop.mSolverVariable, top);
            system.addEquality(widget.mBottom.mSolverVariable, bottom);
            if (widget.mBaselineDistance > 0 || widget.getVisibility() == 8) {
                widget.mBaseline.mSolverVariable = system.createObjectVariable(widget.mBaseline);
                system.addEquality(widget.mBaseline.mSolverVariable, widget.mBaselineDistance + top);
            }
            widget.mVerticalResolution = 2;
            widget.setVerticalDimension(top, bottom);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x003e A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget r3, int r4) {
        /*
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r3.mListDimensionBehaviors
            r0 = r0[r4]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            r2 = 0
            if (r0 == r1) goto L_0x000a
            return r2
        L_0x000a:
            float r0 = r3.mDimensionRatio
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            if (r0 == 0) goto L_0x0020
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r0 = r3.mListDimensionBehaviors
            if (r4 != 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            r0 = r0[r1]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001f
            return r2
        L_0x001f:
            return r2
        L_0x0020:
            if (r4 != 0) goto L_0x0030
            int r0 = r3.mMatchConstraintDefaultWidth
            if (r0 == 0) goto L_0x0027
            return r2
        L_0x0027:
            int r0 = r3.mMatchConstraintMinWidth
            if (r0 != 0) goto L_0x002f
            int r0 = r3.mMatchConstraintMaxWidth
            if (r0 == 0) goto L_0x003e
        L_0x002f:
            return r2
        L_0x0030:
            int r0 = r3.mMatchConstraintDefaultHeight
            if (r0 == 0) goto L_0x0035
            return r2
        L_0x0035:
            int r0 = r3.mMatchConstraintMinHeight
            if (r0 != 0) goto L_0x003f
            int r0 = r3.mMatchConstraintMaxHeight
            if (r0 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            return r1
        L_0x003f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.optimizableMatchConstraint(android.support.constraint.solver.widgets.ConstraintWidget, int):boolean");
    }

    static void analyze(int optimisationLevel, ConstraintWidget widget) {
        ConstraintWidget constraintWidget = widget;
        widget.updateResolutionNodes();
        ResolutionAnchor leftNode = constraintWidget.mLeft.getResolutionNode();
        ResolutionAnchor topNode = constraintWidget.mTop.getResolutionNode();
        ResolutionAnchor rightNode = constraintWidget.mRight.getResolutionNode();
        ResolutionAnchor bottomNode = constraintWidget.mBottom.getResolutionNode();
        boolean optimiseDimensions = (optimisationLevel & 8) == 8;
        boolean isOptimizableHorizontalMatch = constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 0);
        if (!(leftNode.type == 4 || rightNode.type == 4)) {
            if (constraintWidget.mListDimensionBehaviors[0] == DimensionBehaviour.FIXED || (isOptimizableHorizontalMatch && widget.getVisibility() == 8)) {
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    leftNode.setType(1);
                    rightNode.setType(1);
                    if (optimiseDimensions) {
                        rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        rightNode.dependsOn(leftNode, widget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget == null) {
                    leftNode.setType(1);
                    rightNode.setType(1);
                    if (optimiseDimensions) {
                        rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        rightNode.dependsOn(leftNode, widget.getWidth());
                    }
                } else if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget != null) {
                    leftNode.setType(1);
                    rightNode.setType(1);
                    leftNode.dependsOn(rightNode, -widget.getWidth());
                    if (optimiseDimensions) {
                        leftNode.dependsOn(rightNode, -1, widget.getResolutionWidth());
                    } else {
                        leftNode.dependsOn(rightNode, -widget.getWidth());
                    }
                } else if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                    leftNode.setType(2);
                    rightNode.setType(2);
                    if (optimiseDimensions) {
                        widget.getResolutionWidth().addDependent(leftNode);
                        widget.getResolutionWidth().addDependent(rightNode);
                        leftNode.setOpposite(rightNode, -1, widget.getResolutionWidth());
                        rightNode.setOpposite(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        leftNode.setOpposite(rightNode, (float) (-widget.getWidth()));
                        rightNode.setOpposite(leftNode, (float) widget.getWidth());
                    }
                }
            } else if (isOptimizableHorizontalMatch) {
                int width = widget.getWidth();
                leftNode.setType(1);
                rightNode.setType(1);
                if (constraintWidget.mLeft.mTarget == null && constraintWidget.mRight.mTarget == null) {
                    if (optimiseDimensions) {
                        rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                    } else {
                        rightNode.dependsOn(leftNode, width);
                    }
                } else if (constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget != null) {
                    if (constraintWidget.mLeft.mTarget != null || constraintWidget.mRight.mTarget == null) {
                        if (!(constraintWidget.mLeft.mTarget == null || constraintWidget.mRight.mTarget == null)) {
                            if (optimiseDimensions) {
                                widget.getResolutionWidth().addDependent(leftNode);
                                widget.getResolutionWidth().addDependent(rightNode);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                leftNode.setType(3);
                                rightNode.setType(3);
                                leftNode.setOpposite(rightNode, 0.0f);
                                rightNode.setOpposite(leftNode, 0.0f);
                            } else {
                                leftNode.setType(2);
                                rightNode.setType(2);
                                leftNode.setOpposite(rightNode, (float) (-width));
                                rightNode.setOpposite(leftNode, (float) width);
                                constraintWidget.setWidth(width);
                            }
                        }
                    } else if (optimiseDimensions) {
                        leftNode.dependsOn(rightNode, -1, widget.getResolutionWidth());
                    } else {
                        leftNode.dependsOn(rightNode, -width);
                    }
                } else if (optimiseDimensions) {
                    rightNode.dependsOn(leftNode, 1, widget.getResolutionWidth());
                } else {
                    rightNode.dependsOn(leftNode, width);
                }
            }
        }
        boolean isOptimizableVerticalMatch = constraintWidget.mListDimensionBehaviors[1] == DimensionBehaviour.MATCH_CONSTRAINT && optimizableMatchConstraint(constraintWidget, 1);
        if (topNode.type != 4 && bottomNode.type != 4) {
            if (constraintWidget.mListDimensionBehaviors[1] == DimensionBehaviour.FIXED || (isOptimizableVerticalMatch && widget.getVisibility() == 8)) {
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    topNode.setType(1);
                    bottomNode.setType(1);
                    if (optimiseDimensions) {
                        bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                    } else {
                        bottomNode.dependsOn(topNode, widget.getHeight());
                    }
                    if (constraintWidget.mBaseline.mTarget != null) {
                        constraintWidget.mBaseline.getResolutionNode().setType(1);
                        topNode.dependsOn(1, constraintWidget.mBaseline.getResolutionNode(), -constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget == null) {
                    topNode.setType(1);
                    bottomNode.setType(1);
                    if (optimiseDimensions) {
                        bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                    } else {
                        bottomNode.dependsOn(topNode, widget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget != null) {
                    topNode.setType(1);
                    bottomNode.setType(1);
                    if (optimiseDimensions) {
                        topNode.dependsOn(bottomNode, -1, widget.getResolutionHeight());
                    } else {
                        topNode.dependsOn(bottomNode, -widget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                    }
                } else if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                    topNode.setType(2);
                    bottomNode.setType(2);
                    if (optimiseDimensions) {
                        topNode.setOpposite(bottomNode, -1, widget.getResolutionHeight());
                        bottomNode.setOpposite(topNode, 1, widget.getResolutionHeight());
                        widget.getResolutionHeight().addDependent(topNode);
                        widget.getResolutionWidth().addDependent(bottomNode);
                    } else {
                        topNode.setOpposite(bottomNode, (float) (-widget.getHeight()));
                        bottomNode.setOpposite(topNode, (float) widget.getHeight());
                    }
                    if (constraintWidget.mBaselineDistance > 0) {
                        constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                    }
                }
            } else if (isOptimizableVerticalMatch) {
                int height = widget.getHeight();
                topNode.setType(1);
                bottomNode.setType(1);
                if (constraintWidget.mTop.mTarget == null && constraintWidget.mBottom.mTarget == null) {
                    if (optimiseDimensions) {
                        bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                    } else {
                        bottomNode.dependsOn(topNode, height);
                    }
                } else if (constraintWidget.mTop.mTarget == null || constraintWidget.mBottom.mTarget != null) {
                    if (constraintWidget.mTop.mTarget != null || constraintWidget.mBottom.mTarget == null) {
                        if (constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null) {
                            if (optimiseDimensions) {
                                widget.getResolutionHeight().addDependent(topNode);
                                widget.getResolutionWidth().addDependent(bottomNode);
                            }
                            if (constraintWidget.mDimensionRatio == 0.0f) {
                                topNode.setType(3);
                                bottomNode.setType(3);
                                topNode.setOpposite(bottomNode, 0.0f);
                                bottomNode.setOpposite(topNode, 0.0f);
                                return;
                            }
                            topNode.setType(2);
                            bottomNode.setType(2);
                            topNode.setOpposite(bottomNode, (float) (-height));
                            bottomNode.setOpposite(topNode, (float) height);
                            constraintWidget.setHeight(height);
                            if (constraintWidget.mBaselineDistance > 0) {
                                constraintWidget.mBaseline.getResolutionNode().dependsOn(1, topNode, constraintWidget.mBaselineDistance);
                            }
                        }
                    } else if (optimiseDimensions) {
                        topNode.dependsOn(bottomNode, -1, widget.getResolutionHeight());
                    } else {
                        topNode.dependsOn(bottomNode, -height);
                    }
                } else if (optimiseDimensions) {
                    bottomNode.dependsOn(topNode, 1, widget.getResolutionHeight());
                } else {
                    bottomNode.dependsOn(topNode, height);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean applyChainOptimized(android.support.constraint.solver.widgets.ConstraintWidgetContainer r44, android.support.constraint.solver.LinearSystem r45, int r46, int r47, android.support.constraint.solver.widgets.ChainHead r48) {
        /*
            r0 = r45
            r1 = r48
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r1.mFirst
            android.support.constraint.solver.widgets.ConstraintWidget r3 = r1.mLast
            android.support.constraint.solver.widgets.ConstraintWidget r4 = r1.mFirstVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r5 = r1.mLastVisibleWidget
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r1.mHead
            r7 = r2
            r8 = 0
            r9 = 0
            r10 = 0
            float r11 = r1.mTotalWeight
            android.support.constraint.solver.widgets.ConstraintWidget r12 = r1.mFirstMatchConstraintWidget
            android.support.constraint.solver.widgets.ConstraintWidget r13 = r1.mLastMatchConstraintWidget
            r1 = r44
            r14 = r7
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r7 = r1.mListDimensionBehaviors
            r7 = r7[r46]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r1 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            r15 = 0
            r16 = r8
            if (r7 != r1) goto L_0x0028
            r1 = 1
            goto L_0x0029
        L_0x0028:
            r1 = 0
        L_0x0029:
            r7 = 0
            r17 = 0
            r18 = 0
            if (r46 != 0) goto L_0x004d
            int r8 = r6.mHorizontalChainStyle
            if (r8 != 0) goto L_0x0036
            r8 = 1
            goto L_0x0037
        L_0x0036:
            r8 = 0
        L_0x0037:
            r7 = r8
            int r8 = r6.mHorizontalChainStyle
            r20 = r1
            r1 = 1
            if (r8 != r1) goto L_0x0041
            r1 = 1
            goto L_0x0042
        L_0x0041:
            r1 = 0
        L_0x0042:
            int r8 = r6.mHorizontalChainStyle
            r21 = r1
            r1 = 2
            if (r8 != r1) goto L_0x004b
            r1 = 1
            goto L_0x004c
        L_0x004b:
            r1 = 0
        L_0x004c:
            goto L_0x006b
        L_0x004d:
            r20 = r1
            int r1 = r6.mVerticalChainStyle
            if (r1 != 0) goto L_0x0055
            r1 = 1
            goto L_0x0056
        L_0x0055:
            r1 = 0
        L_0x0056:
            r7 = r1
            int r1 = r6.mVerticalChainStyle
            r8 = 1
            if (r1 != r8) goto L_0x005e
            r1 = 1
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            int r8 = r6.mVerticalChainStyle
            r22 = r1
            r1 = 2
            if (r8 != r1) goto L_0x0068
            r1 = 1
            goto L_0x0069
        L_0x0068:
            r1 = 0
        L_0x0069:
            r21 = r22
        L_0x006b:
            r8 = 0
            r17 = 0
            r23 = r6
            r6 = r10
            r10 = r14
            r14 = r8
            r8 = 0
        L_0x0074:
            if (r9 != 0) goto L_0x0128
            r24 = r9
            int r9 = r10.getVisibility()
            r25 = r12
            r12 = 8
            if (r9 == r12) goto L_0x00b7
            int r8 = r8 + 1
            if (r46 != 0) goto L_0x008d
            int r9 = r10.getWidth()
            float r9 = (float) r9
            float r14 = r14 + r9
            goto L_0x0093
        L_0x008d:
            int r9 = r10.getHeight()
            float r9 = (float) r9
            float r14 = r14 + r9
        L_0x0093:
            if (r10 == r4) goto L_0x009f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r10.mListAnchors
            r9 = r9[r47]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r14 = r14 + r9
        L_0x009f:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r10.mListAnchors
            r9 = r9[r47]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r17 = r17 + r9
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r10.mListAnchors
            int r18 = r47 + 1
            r9 = r9[r18]
            int r9 = r9.getMargin()
            float r9 = (float) r9
            float r17 = r17 + r9
        L_0x00b7:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r10.mListAnchors
            r9 = r9[r47]
            r26 = r8
            int r8 = r10.getVisibility()
            if (r8 == r12) goto L_0x00eb
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r8 = r10.mListDimensionBehaviors
            r8 = r8[r46]
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r12 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT
            if (r8 != r12) goto L_0x00eb
            int r6 = r6 + 1
            if (r46 != 0) goto L_0x00dd
            int r8 = r10.mMatchConstraintDefaultWidth
            if (r8 == 0) goto L_0x00d4
            return r15
        L_0x00d4:
            int r8 = r10.mMatchConstraintMinWidth
            if (r8 != 0) goto L_0x00dc
            int r8 = r10.mMatchConstraintMaxWidth
            if (r8 == 0) goto L_0x00eb
        L_0x00dc:
            return r15
        L_0x00dd:
            int r8 = r10.mMatchConstraintDefaultHeight
            if (r8 == 0) goto L_0x00e2
            return r15
        L_0x00e2:
            int r8 = r10.mMatchConstraintMinHeight
            if (r8 != 0) goto L_0x00ea
            int r8 = r10.mMatchConstraintMaxHeight
            if (r8 == 0) goto L_0x00eb
        L_0x00ea:
            return r15
        L_0x00eb:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r8 = r10.mListAnchors
            int r12 = r47 + 1
            r8 = r8[r12]
            android.support.constraint.solver.widgets.ConstraintAnchor r8 = r8.mTarget
            if (r8 == 0) goto L_0x0111
            android.support.constraint.solver.widgets.ConstraintWidget r12 = r8.mOwner
            r27 = r6
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r6 = r6[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            if (r6 == 0) goto L_0x010f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r12.mListAnchors
            r6 = r6[r47]
            android.support.constraint.solver.widgets.ConstraintAnchor r6 = r6.mTarget
            android.support.constraint.solver.widgets.ConstraintWidget r6 = r6.mOwner
            if (r6 == r10) goto L_0x010c
            goto L_0x010f
        L_0x010c:
            r16 = r12
            goto L_0x0116
        L_0x010f:
            r6 = 0
            goto L_0x0114
        L_0x0111:
            r27 = r6
            r6 = 0
        L_0x0114:
            r16 = r6
        L_0x0116:
            if (r16 == 0) goto L_0x011e
            r6 = r16
            r10 = r6
            r9 = r24
            goto L_0x0120
        L_0x011e:
            r6 = 1
            r9 = r6
        L_0x0120:
            r12 = r25
            r8 = r26
            r6 = r27
            goto L_0x0074
        L_0x0128:
            r24 = r9
            r25 = r12
            android.support.constraint.solver.widgets.ConstraintAnchor[] r9 = r2.mListAnchors
            r9 = r9[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r9 = r9.getResolutionNode()
            android.support.constraint.solver.widgets.ConstraintAnchor[] r12 = r3.mListAnchors
            int r18 = r47 + 1
            r12 = r12[r18]
            android.support.constraint.solver.widgets.ResolutionAnchor r12 = r12.getResolutionNode()
            r28 = r3
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r9.target
            if (r3 == 0) goto L_0x045a
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r12.target
            if (r3 != 0) goto L_0x015a
            r3 = r2
            r41 = r6
            r36 = r7
            r42 = r8
            r32 = r10
            r43 = r11
            r33 = r12
            r29 = r13
            r8 = r4
            goto L_0x046a
        L_0x015a:
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r9.target
            int r3 = r3.state
            r29 = r13
            r13 = 1
            if (r3 == r13) goto L_0x016a
            android.support.constraint.solver.widgets.ResolutionAnchor r3 = r12.target
            int r3 = r3.state
            if (r3 == r13) goto L_0x016a
            return r15
        L_0x016a:
            if (r6 <= 0) goto L_0x016f
            if (r6 == r8) goto L_0x016f
            return r15
        L_0x016f:
            r3 = 0
            if (r1 != 0) goto L_0x0176
            if (r7 != 0) goto L_0x0176
            if (r21 == 0) goto L_0x018f
        L_0x0176:
            if (r4 == 0) goto L_0x0181
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r4.mListAnchors
            r13 = r13[r47]
            int r13 = r13.getMargin()
            float r3 = (float) r13
        L_0x0181:
            if (r5 == 0) goto L_0x018f
            android.support.constraint.solver.widgets.ConstraintAnchor[] r13 = r5.mListAnchors
            int r18 = r47 + 1
            r13 = r13[r18]
            int r13 = r13.getMargin()
            float r13 = (float) r13
            float r3 = r3 + r13
        L_0x018f:
            android.support.constraint.solver.widgets.ResolutionAnchor r13 = r9.target
            float r13 = r13.resolvedOffset
            r30 = r2
            android.support.constraint.solver.widgets.ResolutionAnchor r2 = r12.target
            float r2 = r2.resolvedOffset
            r18 = 0
            int r19 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r19 >= 0) goto L_0x01a4
            float r19 = r2 - r13
            float r19 = r19 - r14
        L_0x01a3:
            goto L_0x01a9
        L_0x01a4:
            float r19 = r13 - r2
            float r19 = r19 - r14
            goto L_0x01a3
        L_0x01a9:
            r26 = 1
            if (r6 <= 0) goto L_0x02bb
            if (r6 != r8) goto L_0x02bb
            android.support.constraint.solver.widgets.ConstraintWidget r18 = r10.getParent()
            if (r18 == 0) goto L_0x01c6
            r31 = r2
            android.support.constraint.solver.widgets.ConstraintWidget r2 = r10.getParent()
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour[] r2 = r2.mListDimensionBehaviors
            r2 = r2[r46]
            r32 = r10
            android.support.constraint.solver.widgets.ConstraintWidget$DimensionBehaviour r10 = android.support.constraint.solver.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r2 != r10) goto L_0x01ca
            return r15
        L_0x01c6:
            r31 = r2
            r32 = r10
        L_0x01ca:
            float r19 = r19 + r14
            float r19 = r19 - r17
            r2 = r4
            r10 = r13
            if (r7 == 0) goto L_0x01d6
            float r15 = r17 - r3
            float r19 = r19 - r15
        L_0x01d6:
            if (r7 == 0) goto L_0x01fe
            r33 = r12
            android.support.constraint.solver.widgets.ConstraintAnchor[] r12 = r2.mListAnchors
            int r15 = r47 + 1
            r12 = r12[r15]
            int r12 = r12.getMargin()
            float r12 = (float) r12
            float r10 = r10 + r12
            android.support.constraint.solver.widgets.ConstraintWidget[] r12 = r2.mListNextVisibleWidget
            r12 = r12[r46]
            if (r12 == 0) goto L_0x01fb
            r34 = r2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r2 = r12.mListAnchors
            r2 = r2[r47]
            int r2 = r2.getMargin()
            float r2 = (float) r2
            float r10 = r10 + r2
            r2 = r34
            goto L_0x0204
        L_0x01fb:
            r34 = r2
            goto L_0x0204
        L_0x01fe:
            r34 = r2
            r33 = r12
            r12 = r16
        L_0x0204:
            if (r2 == 0) goto L_0x02ad
            android.support.constraint.solver.Metrics r15 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r15 == 0) goto L_0x022f
            r35 = r12
            android.support.constraint.solver.Metrics r12 = android.support.constraint.solver.LinearSystem.sMetrics
            r36 = r7
            r37 = r8
            long r7 = r12.nonresolvedWidgets
            r39 = r3
            r38 = r4
            long r3 = r7 - r26
            r12.nonresolvedWidgets = r3
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r3.resolvedWidgets
            r40 = r13
            long r12 = r7 + r26
            r3.resolvedWidgets = r12
            android.support.constraint.solver.Metrics r3 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r3.chainConnectionResolved
            long r12 = r7 + r26
            r3.chainConnectionResolved = r12
            goto L_0x023b
        L_0x022f:
            r39 = r3
            r38 = r4
            r36 = r7
            r37 = r8
            r35 = r12
            r40 = r13
        L_0x023b:
            android.support.constraint.solver.widgets.ConstraintWidget[] r3 = r2.mListNextVisibleWidget
            r12 = r3[r46]
            if (r12 != 0) goto L_0x0243
            if (r2 != r5) goto L_0x02a0
        L_0x0243:
            float r3 = (float) r6
            float r3 = r19 / r3
            r4 = 0
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x0253
            float[] r4 = r2.mWeight
            r4 = r4[r46]
            float r4 = r4 * r19
            float r3 = r4 / r11
        L_0x0253:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r47]
            int r4 = r4.getMargin()
            float r4 = (float) r4
            float r10 = r10 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            r4.resolve(r7, r10)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            int r7 = r47 + 1
            r4 = r4[r7]
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            float r8 = r10 + r3
            r4.resolve(r7, r8)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            r4 = r4[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
            r4.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            int r7 = r47 + 1
            r4 = r4[r7]
            android.support.constraint.solver.widgets.ResolutionAnchor r4 = r4.getResolutionNode()
            r4.addResolvedValue(r0)
            float r10 = r10 + r3
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r2.mListAnchors
            int r7 = r47 + 1
            r4 = r4[r7]
            int r4 = r4.getMargin()
            float r4 = (float) r4
            float r10 = r10 + r4
        L_0x02a0:
            r2 = r12
            r7 = r36
            r8 = r37
            r4 = r38
            r3 = r39
            r13 = r40
            goto L_0x0204
        L_0x02ad:
            r39 = r3
            r38 = r4
            r36 = r7
            r37 = r8
            r35 = r12
            r40 = r13
            r3 = 1
            return r3
        L_0x02bb:
            r31 = r2
            r39 = r3
            r38 = r4
            r36 = r7
            r37 = r8
            r32 = r10
            r33 = r12
            r40 = r13
            int r2 = (r19 > r14 ? 1 : (r19 == r14 ? 0 : -1))
            if (r2 >= 0) goto L_0x02d0
            return r15
        L_0x02d0:
            if (r1 == 0) goto L_0x0374
            float r19 = r19 - r39
            r2 = r38
            r3 = r30
            float r4 = r3.getHorizontalBiasPercent()
            float r4 = r4 * r19
            float r13 = r40 + r4
            r10 = r2
            r19 = r13
        L_0x02e3:
            if (r10 == 0) goto L_0x036a
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r2 == 0) goto L_0x0301
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r2.nonresolvedWidgets
            long r12 = r7 - r26
            r2.nonresolvedWidgets = r12
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r2.resolvedWidgets
            long r12 = r7 + r26
            r2.resolvedWidgets = r12
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            long r7 = r2.chainConnectionResolved
            long r12 = r7 + r26
            r2.chainConnectionResolved = r12
        L_0x0301:
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r10.mListNextVisibleWidget
            r16 = r2[r46]
            if (r16 != 0) goto L_0x0309
            if (r10 != r5) goto L_0x0366
        L_0x0309:
            r2 = 0
            if (r46 != 0) goto L_0x0312
            int r4 = r10.getWidth()
            float r2 = (float) r4
            goto L_0x0317
        L_0x0312:
            int r4 = r10.getHeight()
            float r2 = (float) r4
        L_0x0317:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r4 = r10.mListAnchors
            r4 = r4[r47]
            int r4 = r4.getMargin()
            float r4 = (float) r4
            float r4 = r19 + r4
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            r7 = r7[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r7.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r9.resolvedTarget
            r7.resolve(r8, r4)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            int r8 = r47 + 1
            r7 = r7[r8]
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r7.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r8 = r9.resolvedTarget
            float r12 = r4 + r2
            r7.resolve(r8, r12)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            r7 = r7[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r7.getResolutionNode()
            r7.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            int r8 = r47 + 1
            r7 = r7[r8]
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r7.getResolutionNode()
            r7.addResolvedValue(r0)
            float r4 = r4 + r2
            android.support.constraint.solver.widgets.ConstraintAnchor[] r7 = r10.mListAnchors
            int r8 = r47 + 1
            r7 = r7[r8]
            int r7 = r7.getMargin()
            float r7 = (float) r7
            float r19 = r4 + r7
        L_0x0366:
            r10 = r16
            goto L_0x02e3
        L_0x036a:
            r41 = r6
            r43 = r11
        L_0x036e:
            r42 = r37
            r8 = r38
            goto L_0x0458
        L_0x0374:
            r3 = r30
            if (r36 != 0) goto L_0x0382
            if (r21 == 0) goto L_0x037b
            goto L_0x0382
        L_0x037b:
            r41 = r6
            r43 = r11
            r10 = r32
            goto L_0x036e
        L_0x0382:
            if (r36 == 0) goto L_0x0387
            float r19 = r19 - r39
            goto L_0x038b
        L_0x0387:
            if (r21 == 0) goto L_0x038b
            float r19 = r19 - r39
        L_0x038b:
            r2 = r38
            int r8 = r37 + 1
            float r4 = (float) r8
            float r4 = r19 / r4
            if (r21 == 0) goto L_0x03a4
            r7 = r37
            r8 = 1
            if (r7 <= r8) goto L_0x039f
            int r8 = r7 + -1
            float r8 = (float) r8
            float r4 = r19 / r8
            goto L_0x03a6
        L_0x039f:
            r8 = 1073741824(0x40000000, float:2.0)
            float r4 = r19 / r8
            goto L_0x03a6
        L_0x03a4:
            r7 = r37
        L_0x03a6:
            float r13 = r40 + r4
            if (r21 == 0) goto L_0x03bb
            r8 = 1
            if (r7 <= r8) goto L_0x03bb
            r8 = r38
            android.support.constraint.solver.widgets.ConstraintAnchor[] r10 = r8.mListAnchors
            r10 = r10[r47]
            int r10 = r10.getMargin()
            float r10 = (float) r10
            float r13 = r40 + r10
            goto L_0x03bd
        L_0x03bb:
            r8 = r38
        L_0x03bd:
            if (r36 == 0) goto L_0x03cb
            if (r8 == 0) goto L_0x03cb
            android.support.constraint.solver.widgets.ConstraintAnchor[] r10 = r8.mListAnchors
            r10 = r10[r47]
            int r10 = r10.getMargin()
            float r10 = (float) r10
            float r13 = r13 + r10
        L_0x03cb:
            r10 = r2
        L_0x03cc:
            if (r10 == 0) goto L_0x0450
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            if (r2 == 0) goto L_0x03f1
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            r41 = r6
            r42 = r7
            long r6 = r2.nonresolvedWidgets
            r43 = r11
            long r11 = r6 - r26
            r2.nonresolvedWidgets = r11
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            long r6 = r2.resolvedWidgets
            long r11 = r6 + r26
            r2.resolvedWidgets = r11
            android.support.constraint.solver.Metrics r2 = android.support.constraint.solver.LinearSystem.sMetrics
            long r6 = r2.chainConnectionResolved
            long r11 = r6 + r26
            r2.chainConnectionResolved = r11
            goto L_0x03f7
        L_0x03f1:
            r41 = r6
            r42 = r7
            r43 = r11
        L_0x03f7:
            android.support.constraint.solver.widgets.ConstraintWidget[] r2 = r10.mListNextVisibleWidget
            r16 = r2[r46]
            if (r16 != 0) goto L_0x03ff
            if (r10 != r5) goto L_0x0446
        L_0x03ff:
            r2 = 0
            if (r46 != 0) goto L_0x0408
            int r6 = r10.getWidth()
            float r2 = (float) r6
            goto L_0x040d
        L_0x0408:
            int r6 = r10.getHeight()
            float r2 = (float) r6
        L_0x040d:
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r10.mListAnchors
            r6 = r6[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            r6.resolve(r7, r13)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r10.mListAnchors
            int r7 = r47 + 1
            r6 = r6[r7]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            android.support.constraint.solver.widgets.ResolutionAnchor r7 = r9.resolvedTarget
            float r11 = r13 + r2
            r6.resolve(r7, r11)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r10.mListAnchors
            r6 = r6[r47]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r6.addResolvedValue(r0)
            android.support.constraint.solver.widgets.ConstraintAnchor[] r6 = r10.mListAnchors
            int r7 = r47 + 1
            r6 = r6[r7]
            android.support.constraint.solver.widgets.ResolutionAnchor r6 = r6.getResolutionNode()
            r6.addResolvedValue(r0)
            float r6 = r2 + r4
            float r13 = r13 + r6
        L_0x0446:
            r10 = r16
            r6 = r41
            r7 = r42
            r11 = r43
            goto L_0x03cc
        L_0x0450:
            r41 = r6
            r42 = r7
            r43 = r11
            r19 = r13
        L_0x0458:
            r2 = 1
            return r2
        L_0x045a:
            r3 = r2
            r41 = r6
            r36 = r7
            r42 = r8
            r32 = r10
            r43 = r11
            r33 = r12
            r29 = r13
            r8 = r4
        L_0x046a:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.solver.widgets.Optimizer.applyChainOptimized(android.support.constraint.solver.widgets.ConstraintWidgetContainer, android.support.constraint.solver.LinearSystem, int, int, android.support.constraint.solver.widgets.ChainHead):boolean");
    }
}
