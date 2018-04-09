.class Landroid/support/design/widget/l$b;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/design/widget/l;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "b"
.end annotation


# instance fields
.field final a:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/support/design/widget/l$a;",
            ">;"
        }
    .end annotation
.end field

.field b:I

.field c:Z


# direct methods
.method constructor <init>(ILandroid/support/design/widget/l$a;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Landroid/support/design/widget/l$b;->a:Ljava/lang/ref/WeakReference;

    iput p1, p0, Landroid/support/design/widget/l$b;->b:I

    return-void
.end method


# virtual methods
.method a(Landroid/support/design/widget/l$a;)Z
    .locals 1

    if-eqz p1, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l$b;->a:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
