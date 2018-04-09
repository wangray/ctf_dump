.class Landroid/support/design/widget/l;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/design/widget/l$b;,
        Landroid/support/design/widget/l$a;
    }
.end annotation


# static fields
.field private static a:Landroid/support/design/widget/l;


# instance fields
.field private final b:Ljava/lang/Object;

.field private final c:Landroid/os/Handler;

.field private d:Landroid/support/design/widget/l$b;

.field private e:Landroid/support/design/widget/l$b;


# direct methods
.method private constructor <init>()V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    new-instance v2, Landroid/support/design/widget/l$1;

    invoke-direct {v2, p0}, Landroid/support/design/widget/l$1;-><init>(Landroid/support/design/widget/l;)V

    invoke-direct {v0, v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;Landroid/os/Handler$Callback;)V

    iput-object v0, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    return-void
.end method

.method static a()Landroid/support/design/widget/l;
    .locals 1

    sget-object v0, Landroid/support/design/widget/l;->a:Landroid/support/design/widget/l;

    if-nez v0, :cond_0

    new-instance v0, Landroid/support/design/widget/l;

    invoke-direct {v0}, Landroid/support/design/widget/l;-><init>()V

    sput-object v0, Landroid/support/design/widget/l;->a:Landroid/support/design/widget/l;

    :cond_0
    sget-object v0, Landroid/support/design/widget/l;->a:Landroid/support/design/widget/l;

    return-object v0
.end method

.method private a(Landroid/support/design/widget/l$b;I)Z
    .locals 2

    iget-object v0, p1, Landroid/support/design/widget/l$b;->a:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/l$a;

    if-eqz v0, :cond_0

    iget-object v1, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    invoke-virtual {v1, p1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    invoke-interface {v0, p2}, Landroid/support/design/widget/l$a;->a(I)V

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private b()V
    .locals 2

    const/4 v1, 0x0

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    iput-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    iput-object v1, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    iget-object v0, v0, Landroid/support/design/widget/l$b;->a:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/design/widget/l$a;

    if-eqz v0, :cond_1

    invoke-interface {v0}, Landroid/support/design/widget/l$a;->a()V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-object v1, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    goto :goto_0
.end method

.method private b(Landroid/support/design/widget/l$b;)V
    .locals 6

    iget v0, p1, Landroid/support/design/widget/l$b;->b:I

    const/4 v1, -0x2

    if-ne v0, v1, :cond_0

    :goto_0
    return-void

    :cond_0
    const/16 v0, 0xabe

    iget v1, p1, Landroid/support/design/widget/l$b;->b:I

    if-lez v1, :cond_2

    iget v0, p1, Landroid/support/design/widget/l$b;->b:I

    :cond_1
    :goto_1
    iget-object v1, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    invoke-virtual {v1, p1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iget-object v1, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    iget-object v2, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    const/4 v3, 0x0

    invoke-static {v2, v3, p1}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v2

    int-to-long v4, v0

    invoke-virtual {v1, v2, v4, v5}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto :goto_0

    :cond_2
    iget v1, p1, Landroid/support/design/widget/l$b;->b:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    const/16 v0, 0x5dc

    goto :goto_1
.end method

.method private f(Landroid/support/design/widget/l$a;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-virtual {v0, p1}, Landroid/support/design/widget/l$b;->a(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private g(Landroid/support/design/widget/l$a;)Z
    .locals 1

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    invoke-virtual {v0, p1}, Landroid/support/design/widget/l$b;->a(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a(ILandroid/support/design/widget/l$a;)V
    .locals 3

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p2}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    iput p1, v0, Landroid/support/design/widget/l$b;->b:I

    iget-object v0, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    iget-object v2, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-direct {p0, v0}, Landroid/support/design/widget/l;->b(Landroid/support/design/widget/l$b;)V

    monitor-exit v1

    :goto_0
    return-void

    :cond_0
    invoke-direct {p0, p2}, Landroid/support/design/widget/l;->g(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    iput p1, v0, Landroid/support/design/widget/l$b;->b:I

    :goto_1
    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    if-eqz v0, :cond_2

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    const/4 v2, 0x4

    invoke-direct {p0, v0, v2}, Landroid/support/design/widget/l;->a(Landroid/support/design/widget/l$b;I)Z

    move-result v0

    if-eqz v0, :cond_2

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    new-instance v0, Landroid/support/design/widget/l$b;

    invoke-direct {v0, p1, p2}, Landroid/support/design/widget/l$b;-><init>(ILandroid/support/design/widget/l$a;)V

    iput-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    goto :goto_1

    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-direct {p0}, Landroid/support/design/widget/l;->b()V

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method public a(Landroid/support/design/widget/l$a;)V
    .locals 2

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    if-eqz v0, :cond_0

    invoke-direct {p0}, Landroid/support/design/widget/l;->b()V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Landroid/support/design/widget/l$a;I)V
    .locals 2

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-direct {p0, v0, p2}, Landroid/support/design/widget/l;->a(Landroid/support/design/widget/l$b;I)Z

    :cond_0
    :goto_0
    monitor-exit v1

    return-void

    :cond_1
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->g(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    invoke-direct {p0, v0, p2}, Landroid/support/design/widget/l;->a(Landroid/support/design/widget/l$b;I)Z

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method a(Landroid/support/design/widget/l$b;)V
    .locals 2

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    if-eq v0, p1, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->e:Landroid/support/design/widget/l$b;

    if-ne v0, p1, :cond_1

    :cond_0
    const/4 v0, 0x2

    invoke-direct {p0, p1, v0}, Landroid/support/design/widget/l;->a(Landroid/support/design/widget/l$b;I)Z

    :cond_1
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public b(Landroid/support/design/widget/l$a;)V
    .locals 2

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-direct {p0, v0}, Landroid/support/design/widget/l;->b(Landroid/support/design/widget/l$b;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public c(Landroid/support/design/widget/l$a;)V
    .locals 3

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    iget-boolean v0, v0, Landroid/support/design/widget/l$b;->c:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    const/4 v2, 0x1

    iput-boolean v2, v0, Landroid/support/design/widget/l$b;->c:Z

    iget-object v0, p0, Landroid/support/design/widget/l;->c:Landroid/os/Handler;

    iget-object v2, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-virtual {v0, v2}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public d(Landroid/support/design/widget/l$a;)V
    .locals 3

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    iget-boolean v0, v0, Landroid/support/design/widget/l$b;->c:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    const/4 v2, 0x0

    iput-boolean v2, v0, Landroid/support/design/widget/l$b;->c:Z

    iget-object v0, p0, Landroid/support/design/widget/l;->d:Landroid/support/design/widget/l$b;

    invoke-direct {p0, v0}, Landroid/support/design/widget/l;->b(Landroid/support/design/widget/l$b;)V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public e(Landroid/support/design/widget/l$a;)Z
    .locals 2

    iget-object v1, p0, Landroid/support/design/widget/l;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->f(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0, p1}, Landroid/support/design/widget/l;->g(Landroid/support/design/widget/l$a;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    monitor-exit v1

    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
