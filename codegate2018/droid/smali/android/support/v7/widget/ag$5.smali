.class Landroid/support/v7/widget/ag$5;
.super Landroid/animation/AnimatorListenerAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/ag;->c(Landroid/support/v7/widget/av$w;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Landroid/support/v7/widget/av$w;

.field final synthetic b:Landroid/view/View;

.field final synthetic c:Landroid/view/ViewPropertyAnimator;

.field final synthetic d:Landroid/support/v7/widget/ag;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/ag;Landroid/support/v7/widget/av$w;Landroid/view/View;Landroid/view/ViewPropertyAnimator;)V
    .locals 0

    iput-object p1, p0, Landroid/support/v7/widget/ag$5;->d:Landroid/support/v7/widget/ag;

    iput-object p2, p0, Landroid/support/v7/widget/ag$5;->a:Landroid/support/v7/widget/av$w;

    iput-object p3, p0, Landroid/support/v7/widget/ag$5;->b:Landroid/view/View;

    iput-object p4, p0, Landroid/support/v7/widget/ag$5;->c:Landroid/view/ViewPropertyAnimator;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationCancel(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/ag$5;->b:Landroid/view/View;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    return-void
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/ag$5;->c:Landroid/view/ViewPropertyAnimator;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    iget-object v0, p0, Landroid/support/v7/widget/ag$5;->d:Landroid/support/v7/widget/ag;

    iget-object v1, p0, Landroid/support/v7/widget/ag$5;->a:Landroid/support/v7/widget/av$w;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ag;->k(Landroid/support/v7/widget/av$w;)V

    iget-object v0, p0, Landroid/support/v7/widget/ag$5;->d:Landroid/support/v7/widget/ag;

    iget-object v0, v0, Landroid/support/v7/widget/ag;->d:Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/support/v7/widget/ag$5;->a:Landroid/support/v7/widget/av$w;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Landroid/support/v7/widget/ag$5;->d:Landroid/support/v7/widget/ag;

    invoke-virtual {v0}, Landroid/support/v7/widget/ag;->c()V

    return-void
.end method

.method public onAnimationStart(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Landroid/support/v7/widget/ag$5;->d:Landroid/support/v7/widget/ag;

    iget-object v1, p0, Landroid/support/v7/widget/ag$5;->a:Landroid/support/v7/widget/av$w;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ag;->n(Landroid/support/v7/widget/av$w;)V

    return-void
.end method
