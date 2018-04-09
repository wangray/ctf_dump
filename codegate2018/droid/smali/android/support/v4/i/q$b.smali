.class Landroid/support/v4/i/q$b;
.super Landroid/support/v4/i/q$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/i/q;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "b"
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Landroid/support/v4/i/q$a;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Landroid/view/View;I)V
    .locals 1

    const/4 v0, 0x4

    if-ne p2, v0, :cond_0

    const/4 p2, 0x2

    :cond_0
    invoke-virtual {p1, p2}, Landroid/view/View;->setImportantForAccessibility(I)V

    return-void
.end method

.method public a(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 0

    invoke-virtual {p1, p2}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public a(Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 0

    invoke-virtual {p1, p2}, Landroid/view/View;->postOnAnimation(Ljava/lang/Runnable;)V

    return-void
.end method

.method public a(Landroid/view/View;Ljava/lang/Runnable;J)V
    .locals 1

    invoke-virtual {p1, p2, p3, p4}, Landroid/view/View;->postOnAnimationDelayed(Ljava/lang/Runnable;J)V

    return-void
.end method

.method public b(Landroid/view/View;)Z
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->hasTransientState()Z

    move-result v0

    return v0
.end method

.method public c(Landroid/view/View;)V
    .locals 0

    invoke-virtual {p1}, Landroid/view/View;->postInvalidateOnAnimation()V

    return-void
.end method

.method public d(Landroid/view/View;)I
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getImportantForAccessibility()I

    move-result v0

    return v0
.end method

.method public e(Landroid/view/View;)I
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getMinimumWidth()I

    move-result v0

    return v0
.end method

.method public f(Landroid/view/View;)I
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getMinimumHeight()I

    move-result v0

    return v0
.end method

.method public g(Landroid/view/View;)V
    .locals 0

    invoke-virtual {p1}, Landroid/view/View;->requestFitSystemWindows()V

    return-void
.end method

.method public h(Landroid/view/View;)Z
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->getFitsSystemWindows()Z

    move-result v0

    return v0
.end method

.method public i(Landroid/view/View;)Z
    .locals 1

    invoke-virtual {p1}, Landroid/view/View;->hasOverlappingRendering()Z

    move-result v0

    return v0
.end method
