.class abstract Landroid/support/design/widget/f$e;
.super Landroid/animation/AnimatorListenerAdapter;

# interfaces
.implements Landroid/animation/ValueAnimator$AnimatorUpdateListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/design/widget/f;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "e"
.end annotation


# instance fields
.field private a:Z

.field final synthetic b:Landroid/support/design/widget/f;

.field private c:F

.field private d:F


# direct methods
.method private constructor <init>(Landroid/support/design/widget/f;)V
    .locals 0

    iput-object p1, p0, Landroid/support/design/widget/f$e;->b:Landroid/support/design/widget/f;

    invoke-direct {p0}, Landroid/animation/AnimatorListenerAdapter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Landroid/support/design/widget/f;Landroid/support/design/widget/f$1;)V
    .locals 0

    invoke-direct {p0, p1}, Landroid/support/design/widget/f$e;-><init>(Landroid/support/design/widget/f;)V

    return-void
.end method


# virtual methods
.method protected abstract a()F
.end method

.method public onAnimationEnd(Landroid/animation/Animator;)V
    .locals 2

    iget-object v0, p0, Landroid/support/design/widget/f$e;->b:Landroid/support/design/widget/f;

    iget-object v0, v0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    iget v1, p0, Landroid/support/design/widget/f$e;->d:F

    invoke-virtual {v0, v1}, Landroid/support/design/widget/j;->b(F)V

    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/design/widget/f$e;->a:Z

    return-void
.end method

.method public onAnimationUpdate(Landroid/animation/ValueAnimator;)V
    .locals 4

    iget-boolean v0, p0, Landroid/support/design/widget/f$e;->a:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/f$e;->b:Landroid/support/design/widget/f;

    iget-object v0, v0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    invoke-virtual {v0}, Landroid/support/design/widget/j;->a()F

    move-result v0

    iput v0, p0, Landroid/support/design/widget/f$e;->c:F

    invoke-virtual {p0}, Landroid/support/design/widget/f$e;->a()F

    move-result v0

    iput v0, p0, Landroid/support/design/widget/f$e;->d:F

    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/design/widget/f$e;->a:Z

    :cond_0
    iget-object v0, p0, Landroid/support/design/widget/f$e;->b:Landroid/support/design/widget/f;

    iget-object v0, v0, Landroid/support/design/widget/f;->c:Landroid/support/design/widget/j;

    iget v1, p0, Landroid/support/design/widget/f$e;->c:F

    iget v2, p0, Landroid/support/design/widget/f$e;->d:F

    iget v3, p0, Landroid/support/design/widget/f$e;->c:F

    sub-float/2addr v2, v3

    invoke-virtual {p1}, Landroid/animation/ValueAnimator;->getAnimatedFraction()F

    move-result v3

    mul-float/2addr v2, v3

    add-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/support/design/widget/j;->b(F)V

    return-void
.end method
